package com.jokerdig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker大雄
 * @data 2022/7/23 - 11:47
 **/
@Controller
public class RooterController {

    // 首页
    @RequestMapping({"/","/index","index.html"})
    public String index(){

        return "index";
    }
    // 去登录
    @RequestMapping("toLogin")
    public String toLogin(){

        return "views/login";
    }
    // level1
    @RequestMapping("level1/{id}")
    public String toLevel1(@PathVariable("id") int id){

        return "views/level1/"+id;
    }
    // level2
    @RequestMapping("level2/{id}")
    public String toLevel2(@PathVariable("id") int id){

        return "views/level2/"+id;
    }
    // level3
    @RequestMapping("level3/{id}")
    public String toLevel3(@PathVariable("id") int id){

        return "views/level3/"+id;
    }



}
