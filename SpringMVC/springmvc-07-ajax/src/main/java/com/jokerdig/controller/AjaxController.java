package com.jokerdig.controller;

import com.jokerdig.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/6/16 - 14:24
 **/
@RestController
public class AjaxController {

    // ajax input失去焦点请求
    @RequestMapping("/ajax")
    public void ajax(String name, HttpServletResponse response, Model model) throws IOException {
        System.out.println("a1:param=>"+name);
        if("jokerdig.com".equals(name)){
            model.addAttribute("name",name);
        }else{
            response.getWriter().println("false");
        }
    }

    // 模拟json数据提交到前端
    @RequestMapping("/ajax2")
    public List<User> ajax2(){
        ArrayList<User> userList = new ArrayList<>();
        // 添加
        userList.add(new User("小王",21,"男"));
        userList.add(new User("小张",18,"男"));
        userList.add(new User("小刘",19,"女"));
        return userList;
    }
    // 登录验证
    @RequestMapping("/ajax3")
    public String ajax3(String name,String pwd){
        String msg= "";
        if(name!=null){
            if("admin".equals(name)){
                msg = "ok";
            }else{
                msg = "账号有误";
            }
        }
        if(pwd!=null){
            if("123".equals(pwd)){
                msg = "ok";
            }else{
                msg = "密码有误";
            }
        }
        return msg;
    }


}
