package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joker大雄
 * @data 2022/6/3 - 16:00
 **/
@Controller
public class RestFulController {

    // 原来的： http://localhost:8080/add?a=1&b=2
    // RestFul：http://localhost:8080/add/a/b

    // @RequestMapping("/add/{a}/{b}")
    // @RequestMapping(name="/add/{a}/{b}",method= RequestMethod.GET)
    // @RequestMapping(name="/add/{a}/{b}",method= RequestMethod.POST)
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果1为"+res);

        return "test";
    }
    // 请求地址相同 但走的方法不同
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果2为"+res);

        return "test";
    }


}
