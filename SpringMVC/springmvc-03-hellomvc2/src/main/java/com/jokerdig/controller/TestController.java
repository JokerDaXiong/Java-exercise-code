package com.jokerdig.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joker大雄
 * @data 2022/5/31 - 21:20
 **/
public class TestController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 业务代码
        String result ="TestSpringMVC";
        mav.addObject("msg",result);
        // 视图跳转
        mav.setViewName("test");

        return mav;
    }
}
