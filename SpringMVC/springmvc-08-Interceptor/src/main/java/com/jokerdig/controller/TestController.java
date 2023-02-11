package com.jokerdig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker大雄
 * @data 2022/6/17 - 19:21
 **/
@RestController
public class TestController {
    @GetMapping("/t1")
    public String test(){
        System.out.println("=======TestController===");
        return "ok";
    }
}
