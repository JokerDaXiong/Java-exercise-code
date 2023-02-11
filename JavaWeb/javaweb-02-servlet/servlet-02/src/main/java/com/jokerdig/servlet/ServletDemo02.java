package com.jokerdig.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/3/29 - 18:18
 **/
public class ServletDemo02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了ServletDemo02");
        resp.setContentType("text/html;charset=utf-8");
        // 转发的请求路径
        RequestDispatcher reqD = context.getRequestDispatcher("/para");
        reqD.forward(req,resp);// 调用forward实现请求转发

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
