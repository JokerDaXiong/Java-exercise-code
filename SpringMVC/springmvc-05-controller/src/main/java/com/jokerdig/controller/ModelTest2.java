package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/3 - 17:01
 **/
@Controller
public class ModelTest2 {

    // 第一种方法
    @RequestMapping("mt2/t1")
    public String test(Model model){
        model.addAttribute("msg","ModelTest2");
        return "/WEB-INF/jsp/test.jsp";
    }
    // forward方法
    @RequestMapping("mt2/t2")
    public String test1(Model model){
        model.addAttribute("msg","ModelTest2");
        return "forward:/WEB-INF/jsp/test.jsp";
    }
    // redirect方法
    @RequestMapping("mt2")
    public String test2(Model model){
      //  直接重定向到首页
        return "redirect:index.jsp";
    }
}
