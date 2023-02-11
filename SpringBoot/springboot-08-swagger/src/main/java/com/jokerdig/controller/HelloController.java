package com.jokerdig.controller;

import com.jokerdig.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker大雄
 * @data 2022/7/28 - 12:01
 **/
@RestController
public class HelloController {

    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    // 只要我们在接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping(value="/user")
    public User user(){
        return new User();
    }

    // Operation接口 方法上
    @ApiOperation("Hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

}
