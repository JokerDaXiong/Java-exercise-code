package com.jokerdig.servlet.user;

import com.jokerdig.pojo.User;
import com.jokerdig.service.user.UserServiceImpl;
import com.jokerdig.until.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/14 - 17:18
 **/
public class LoginServlet extends HttpServlet {

    // 调用Service层



    // 登录
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LoginServlet..in..");

        // 获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 和数据库进行对比
        UserServiceImpl userService = new UserServiceImpl();
        User back = userService.login(userCode, userPassword);
        if(back!=null){
            // 登录成功
            req.getSession().setAttribute(Constants.USER_SESSION,back);
            resp.sendRedirect("jsp/frame.jsp");
            System.out.println(back.getUserName());
        }else {
            // 登录失败
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println(back.getUserName());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
