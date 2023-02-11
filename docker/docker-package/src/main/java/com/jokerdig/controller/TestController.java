package com.jokerdig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker大雄
 * @data 2022/9/27 - 17:50
 **/
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "Hey,Joker";
    }
}
