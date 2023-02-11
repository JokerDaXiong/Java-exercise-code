package com.jokerdig.controller;

import com.jokerdig.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/6/3 - 17:48
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    // localhost:8080/user/t1?name=xxx
    @RequestMapping("/t1")
    public String test1(String name, Model model){
        // 1. 接收前端参数
        System.out.println("接收到前端的参数为："+name);
        // 2. 将返回的结果传递到前端
        model.addAttribute("msg",name);
        return "test";
    }

    // 前端接收的是一个对象 User(id name age)
    /*
       1. 接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
       2. 假设传递的是一个对象，匹配对象中的字段名，名字一致则传递值，否则接收不到数据
     */
    @RequestMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    // ModelMap
    @RequestMapping("/t3")
    public String test3(ModelMap modelMap){
        modelMap.addAttribute("msg","ModelMap");
        return "test";
    }

}
