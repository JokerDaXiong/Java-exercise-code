package com.jokerdig.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2022/4/9 - 10:03
 **/
public class CharacterEncodingFilter implements Filter {


    // 初始化 在web服务器启动的时候就已经初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("编码过滤器初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 解决乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("执行前");
        // chain  链
        // 用来行
        chain.doFilter(request,response);
        System.out.println("执行后");
    }
    // 销毁 在web服务器关闭时执行销毁
    public void destroy() {
        System.out.println("编码过滤器已销毁");
    }
}
