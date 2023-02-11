package com.jokerdig.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/3/29 - 17:27
 **/
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        // this.getInitParameter(); 初始化参数
        // this.getServletConfig(); Servlet配置
        // this.getServletContext(); Servlet上下文
        ServletContext context = this.getServletContext();
        String username = "小王";
        // 将数据保存在ServletContext
        context.setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
