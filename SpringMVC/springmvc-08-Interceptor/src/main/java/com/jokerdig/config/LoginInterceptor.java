package com.jokerdig.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Joker大雄
 * @data 2022/6/18 - 10:48
 **/
public class LoginInterceptor implements HandlerInterceptor {
    // 拦截未登录访问首页

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行判断
        HttpSession session = request.getSession();

        if(session.getAttribute("uname")!=null){
            return true;
        }
        // 放行登录页面本身
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        // 第一次登录拦截不验证session
        if(request.getRequestURI().contains("login")){
            return true;
        }

        response.sendRedirect("/user/goLogin");
        return false;
    }
}
