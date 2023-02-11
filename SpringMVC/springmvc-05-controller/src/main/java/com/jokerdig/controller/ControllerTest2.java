package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/1 - 13:55
 **/
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test(Model model){
        model.addAttribute("msg","ControllerTest2");
        return "test";
    }


}
