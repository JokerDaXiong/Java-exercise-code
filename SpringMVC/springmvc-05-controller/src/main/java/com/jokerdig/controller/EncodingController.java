package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Joker大雄
 * @data 2022/6/4 - 16:58
 **/
@Controller
public class EncodingController {

    // 使用过滤器解决乱码
    @PostMapping("eco/pt")
    public String encoding(Model model,String name){
        model.addAttribute("msg",name);
        return "test";
    }
}
