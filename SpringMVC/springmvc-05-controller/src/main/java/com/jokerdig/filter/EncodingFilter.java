package com.jokerdig.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/6/4 - 17:32
 **/
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 解决乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
