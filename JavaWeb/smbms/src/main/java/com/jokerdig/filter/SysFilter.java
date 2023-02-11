package com.jokerdig.filter;

import com.jokerdig.pojo.User;
import com.jokerdig.until.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/15 - 13:42
 **/
public class SysFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        // 获取session中的用户
        User user = (User)req.getSession().getAttribute(Constants.USER_SESSION);
        if(user == null){
            //System.out.println("用户未登录");
            // 用户未登录
            resp.sendRedirect("/smbms/error.jsp");
        }else {
            // 用户已经登录
            // chain 链
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
