package com.jokerdig.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joker大雄
 * @data 2022/5/31 - 18:11
 **/
public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 视图和模型
        ModelAndView mav = new ModelAndView();

        // 封装对象，放在ModelAndView中
        mav.addObject("msg","HelloSpringMVC");
        // 封装要跳转的视图，放在ModelAndView中
        // 结合之前配置的视图解析器 地址为：/WEB-INF/jsp/hello.jsp
        mav.setViewName("hello");
        return mav;
    }
}