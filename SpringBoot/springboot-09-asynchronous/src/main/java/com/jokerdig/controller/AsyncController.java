package com.jokerdig.controller;

import com.jokerdig.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker大雄
 * @data 2022/7/29 - 13:12
 **/
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "ok";
    }
}
