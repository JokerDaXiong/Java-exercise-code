package com.jokerdig.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.jokerdig.pojo.Role;
import com.jokerdig.pojo.User;
import com.jokerdig.service.role.RoleService;
import com.jokerdig.service.role.RoleServiceImpl;
import com.jokerdig.service.user.UserService;
import com.jokerdig.service.user.UserServiceImpl;
import com.jokerdig.until.Constants;
import com.jokerdig.until.PageSupport;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/4/15 - 14:33
 **/

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd")&&method!=null){
            // 修改密码
            this.updatePwd(req,resp);
        }else if(method.equals("pwdmodify")&&method!=null){
            // 验证旧密码
            this.pwdModify(req,resp);
        }else if(method.equals("query")&&method!=null){
            // 用户显示
            this.query(req,resp);
        }else if(method.equals("add")&& method!=null){
            // 添加用户
            this.add(req,resp);
        }else if(method.equals("deluser")&&method!=null){
            //删除用户
            this.delUser(req,resp);
        }else if(method.equals("modify")&&method!=null){
            // 获取要修改的用户
            this.getUserById(req,resp,"usermodify.jsp");
        }else if(method.equals("modifyexe")&&method!=null){
            //修改用户
            this.modify(req,resp);
        } else if (method != null && method.equals("getrolelist")) {
            // 获取角色列表
            this.getRoleList(req, resp);
        }else if (method != null && method.equals("view")) {
            // 显示用户信息
            this.getUserById(req, resp, "userview.jsp");
        } else if (method != null && method.equals("ucexist")) {
            // 验证用户编码
            this.userCodeExist(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    // 实现Servlet复用
    // 用户修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从session中获取用户id
        Object ob = req.getSession().getAttribute(Constants.USER_SESSION);
        // 从页面拿到新密码
        String newPwd = req.getParameter("newpassword");
        // 判断用户是否登录且新密码不为空
        if(ob!=null && !StringUtils.isNullOrEmpty(newPwd)){
            UserService userService = new UserServiceImpl();
            // 把用户id和新密码赋值
            boolean flag = false;
            flag = userService.updatePwd(((User) ob).getId(), newPwd);
            if(flag){
                // 修改成功
                req.setAttribute(Constants.MESSAGE,"密码修改成功，请重新登录");
                // 移除session 用户使用新密码登录
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                // 修改失败
                req.setAttribute(Constants.MESSAGE,"密码修改失败");
            }
        }else {
            req.setAttribute(Constants.MESSAGE,"密码输入有误");
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }

    // 验证旧密码 通过ajax
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object ob = req.getSession().getAttribute(Constants.USER_SESSION);
        // 从ajax请求中拿到旧密码
        String oldPwd = req.getParameter("oldpassword");
        // 使用万能的map
        Map<String,String> resultMap = new HashMap<String,String>();

        if(ob==null){
            // session过期
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldPwd)){
            // 密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) ob).getUserPassword();//session中用户的密码
            if(oldPwd.equals(userPassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter wt = resp.getWriter();
            // JSONArray  阿里巴巴JSON工具类
            wt.write(JSONArray.toJSONString(resultMap));
            wt.flush();
            wt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 用户显示
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询用户列表
        // 从前端获取数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;
        List<User> userList = null;
        List<Role> roleList = null;
        // 获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        // 第一次请求默认是第一页
        int pageSize = 5;
        int currentPageNo = 1;

        if(queryUserName==null){
            queryUserName="";
        }
        if(temp!=null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);// 查询默认值
        }
        if(pageIndex!=null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        // 获取用户总数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        // 总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        // 控制首页和尾页
       int totalPageCount =  pageSupport.getTotalPageCount();// 获取总页数
       if(totalPageCount<1){
           currentPageNo = 1;
       }else if(currentPageNo>totalPageCount){//尾页
           currentPageNo = totalPageCount;
       }
       // 获取用户列表展示
       userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
       req.setAttribute("userList",userList);
       // 获取角色列表
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        // 总页数 当前页数
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);


        // 返回前端
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);
    }
// 添加用户
    public void add(HttpServletRequest req,HttpServletResponse resp) {
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        UserService userService = new UserServiceImpl();
        // 调用前端请求
        try {
            if(userService.add(user)){
                resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
            }else {
                req.getRequestDispatcher("useradd.jsp").forward(req,resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    // 删除用户
    public void delUser(HttpServletRequest req,HttpServletResponse resp){
        String id = req.getParameter("uid");
        Integer delId = 0;
        try {
            delId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            delId = 0;
        }
        HashMap<String,String>resultMap = new HashMap<>();
        if(delId <=0){
            resultMap.put("delResult","notexist");
        }else {
            UserService userService = new UserServiceImpl();
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult","true");
            }else{
                resultMap.put("delResult","false");
            }
        }

        // 把resultMap转换未JSON
        resp.setContentType("application/json");
        try {
            PrintWriter out = resp.getWriter();
            out.write(JSONArray.toJSONString(resultMap));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 获取要修改的用户
    public void getUserById(HttpServletRequest req,HttpServletResponse resp,String url){
        String id =req.getParameter("uid");
        if(!StringUtils.isNullOrEmpty(id)){
            // 调用后台得到的User
            UserService userService = new UserServiceImpl();
            User user = userService.getUserById(id);
            req.setAttribute("user",user);
            try {
                req.getRequestDispatcher(url).forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 修改用户
    public void modify(HttpServletRequest req,HttpServletResponse resp){
        String id = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User) req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        UserService userService = new UserServiceImpl();
        try {
            if (userService.modify(user)) {
                resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
            } else {
                req.getRequestDispatcher("usermodify.jsp").forward(req, resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    // 获取角色列表
    public void getRoleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(roleList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    // 验证用户编码
    public void userCodeExist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //判断用户账号是否可用
        String userCode = request.getParameter("userCode");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (StringUtils.isNullOrEmpty(userCode)) {
            resultMap.put("userCode", "exist");
        } else {
            UserService userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(request,userCode);
            if (null != user) {
                resultMap.put("userCode", "exist");
            } else {
                resultMap.put("userCode", "notexist");
            }
        }

        //把resultMap转为json字符串以json的形式输出
        //配置上下文的输出类型
        response.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter outPrintWriter = response.getWriter();
        //把resultMap转为json字符串 输出
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }


}
