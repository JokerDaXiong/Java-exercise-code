package com.jokerdig.servlet;

import com.jokerdig.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/1 - 14:37
 **/
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 得到session
        HttpSession session = req.getSession();

        // 接收传递的参数
        //String name = (String) session.getAttribute("name");
        // System.out.println(name);
        // 接收传递的对象
        Person person = (Person) session.getAttribute("name");
        System.out.println(person.toString());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
