package com.jokerdig.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joker大雄
 * @data 2022/6/1 - 12:35
 **/
// 只要实现Controller接口的类 就是一个控制器
public class ControllerTest implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();

        mav.addObject("msg","ControllerTest1");
        mav.setViewName("test");
        return mav;
    }
}
