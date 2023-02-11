package com.jokerdig.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/11 - 13:39
 **/
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端请求参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if(username.equals("admin") && pwd.equals("123")){
            System.out.println("登录成功");
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect("../sys/initial.jsp");
        } else {
            System.out.println("登录失败");
            resp.sendRedirect("../login.jsp");
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
