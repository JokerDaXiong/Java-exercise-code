package com.jokerdig.servlet;

import com.jokerdig.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Joker大雄
 * @data 2022/4/1 - 14:37
 **/
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 得到session
        HttpSession session = req.getSession();

        // 给session中存东西
        // 传递字符串
        // session.setAttribute("name","张三");
        // 传递对象
        session.setAttribute("name",new Person("李四",20));
        // 获取session的id
        String sessionid = session.getId();
        // 判断session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功,sessionID："+sessionid);
        }else{
            resp.getWriter().write("session已经被创建,sessionID："+sessionid);
        }

        // session在创建的时候做了什么事情
        Cookie cookie = new Cookie("JSESSIONID", sessionid);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
