package com.jokerdig.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Joker大雄
 * @data 2022/4/1 - 13:11
 **/
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 保存用户上一次访问的时间
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 创建Writer
        PrintWriter out = resp.getWriter();
        // Cookie 服务器从客户获取
        Cookie[] cookies = req.getCookies();// 返回cookie
        // 判断cookie是否存在
        if(cookies!=null){
            // 如果存在
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookies的名字
                if(cookie.getName().equals("lastLoginTime")){
                    // 获取cook里的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    // toLocaleString已被淘汰，这里仅作演示 不推荐使用
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是第一次访问网站");
        }
        // 服务给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //cookie设置有效期
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
