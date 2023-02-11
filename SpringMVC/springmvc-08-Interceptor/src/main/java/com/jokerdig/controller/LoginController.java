package com.jokerdig.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Joker大雄
 * @data 2022/6/18 - 10:33
 **/
@Controller
@RequestMapping("/user")
public class LoginController {

    // 登录验证
    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpSession session){
        // 把用户的信息存放在session中
        if(uname!=null&&pwd!=null){
            if(uname.equals("admin")&&pwd.equals("123456")){
                session.setAttribute("uname",uname);
                return "main";
            }
        }
        return "login";
    }
    // 进入登录页面
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    // 进入首页
    @RequestMapping("/main")
    public String main(HttpSession session){
        return "main";
    }
    // 注销登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("uname");
        return "login";
    }
}
