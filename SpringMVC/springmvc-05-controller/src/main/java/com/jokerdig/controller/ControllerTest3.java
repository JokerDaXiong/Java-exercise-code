package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/1 - 14:11
 **/
@Controller
@RequestMapping("/admin")
public class ControllerTest3 {
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","RequestMapping");
        return "test";
    }
}
