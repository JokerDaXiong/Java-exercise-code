package com.jokerdig.servlet;

import com.jokerdig.pojo.User;
import com.jokerdig.util.SendMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/22 - 13:47
 **/
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户请求，封装为对象
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username,password,email);
        // 用户注册 使用多线程优化用户等待时间
        SendMail send = new SendMail(user);
        // 启动线程
        send.start();
        // 开始注册
        req.setAttribute("msg","注册成功，我们已向您的邮箱发送了一封带有注册信息的电子邮件，请查收！");
        req.getRequestDispatcher("info.jsp").forward(req,resp);







    }
}
