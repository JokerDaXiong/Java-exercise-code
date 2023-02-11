package com.jokerdig.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/11 - 14:03
 **/
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 未登录和注销后不能直接进入首页
        // ServletRequest  HttpServletRequest 转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if(user_session==null){
            resp.sendRedirect("../login.jsp");
        }

        chain.doFilter(request,response);// 链
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
