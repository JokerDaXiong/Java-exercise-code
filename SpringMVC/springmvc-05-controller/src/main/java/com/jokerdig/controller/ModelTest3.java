package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/3 - 17:22
 **/
@Controller
public class ModelTest3 {
    // 请求转发
    @RequestMapping("mt3/t1")
    public String test1(Model model){
        model.addAttribute("msg","ModelTest3");
        return "test";
    }
    // redirect 重定向方法
    @RequestMapping("mt3")
    public String test2(Model model){
        //  直接重定向到首页
        return "redirect:index.jsp";
    }
}
