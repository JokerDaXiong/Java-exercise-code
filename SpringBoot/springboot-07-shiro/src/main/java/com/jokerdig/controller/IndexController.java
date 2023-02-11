package com.jokerdig.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Joker大雄
 * @data 2022/7/26 - 11:04
 **/
@Controller
public class IndexController {

    // 首页
    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }
    // add
    @RequestMapping("/user/add")
    public String add(){

        return "/user/add";
    }
    // update
    @RequestMapping("/user/update")
    public String update(){

        return "/user/update";
    }
    // toLogin
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    // login
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 登录使用token
        try {
            subject.login(token);
            // 简单异常捕获
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
        return "redirect:index";
    }
    // 未授权提示
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "您没有权限访问该页面";
    }
    // logout
    @RequestMapping("/logout")
    public String logout(){
        // 注销登录
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:index";
    }


}
