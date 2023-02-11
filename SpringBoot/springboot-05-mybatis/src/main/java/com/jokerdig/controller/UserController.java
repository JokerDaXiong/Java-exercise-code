package com.jokerdig.controller;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/7/22 - 13:55
 **/
@RestController
public class UserController {

    // 自动注入mapper
    @Autowired
    UserMapper mapper;

    // 查询所有用户
    @RequestMapping("/query")
    public List<User> queryUserList(){
        return mapper.queryUserList();
    }
    // id查询用户
    @RequestMapping("/queryUser/{id}")
    public User queryUserById(@PathVariable("id")int id){
        return mapper.queryUserById(id);
    }
    // 添加用户
    @RequestMapping("/add")
    public String addUser(){
        mapper.addUser(new User(6,"小呆","123123"));
        return "add success";
    }
    // 修改用户
    @RequestMapping("/update")
    public String updateUser(){
        mapper.updateUser(new User(6,"小笨蛋","321321"));
        return "update success";
    }
    // 删除用户
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        mapper.deleteUser(id);
        return "delete success";
    }






}
