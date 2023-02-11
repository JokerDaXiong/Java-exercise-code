package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/1 - 11:58
 **/
@Controller
@RequestMapping("/HelloController")
public class HelloController {

    // 真实访问地址   项目名/HelloController/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        // 封装数据
        model.addAttribute("msg","Hello,SpringMVC-Annotation");
        // return 的结果会被视图解析器处理
        return "hello";
    }


}
