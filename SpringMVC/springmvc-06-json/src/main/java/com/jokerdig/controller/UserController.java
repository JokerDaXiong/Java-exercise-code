package com.jokerdig.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jokerdig.pojo.User;
import com.jokerdig.untils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/6/4 - 20:20
 **/
@Controller
public class UserController {
    // 原始解决json乱码方法
    //  @RequestMapping(value="/j1",produces="application/json;charset=utf-8")
    @RequestMapping("/j1")
    @ResponseBody // 加这个注解就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        // jackson  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();


        User user = new User("小王",18,"男");

        // 把一个Value转换为String
        String str = mapper.writeValueAsString(user);

        return str;
    }

    // 测试集合的输出
    @RequestMapping("/j2")
    @ResponseBody // 加这个注解就不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {

        // jackson  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        List<User> list = new ArrayList<>();

        User user1 = new User("小王1",18,"男");
        User user2 = new User("小王2",18,"女");
        User user3 = new User("小王3",18,"男");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        // 把一个Value转换为String
        String str = new ObjectMapper().writeValueAsString(list);

        return str;
    }

    // 测试时间对象的输出
    @RequestMapping("/j3")
    @ResponseBody // 加这个注解就不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {

        // jackson  ObjectMapper 来格式化时间
        ObjectMapper mapper = new ObjectMapper();
        // 方法2 关闭默认显示时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        // 方法2 使用自定义日期格式
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simp);

        Date date = new Date();
        // 方法1. 将时间戳转换为我们需要的格式
        // SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // simp.format(date);

        // 把一个Value转换为String
        String str = mapper.writeValueAsString(date);

        return str;
    }
    // 传递时间
    @RequestMapping("/j4")
    @ResponseBody // 加这个注解就不会走视图解析器，会直接返回一个字符串
    public String json4(){

        Date date = new Date();

        return new JsonUtils().getJson(date,"yyyy-MM-dd HH:mm:ss");
    }
    @RequestMapping("/j5")
    @ResponseBody // 加这个注解就不会走视图解析器，会直接返回一个字符串
    public String json5(){


        List<User> list = new ArrayList<>();

        User user1 = new User("小王1",18,"男");
        User user2 = new User("小王2",18,"女");
        User user3 = new User("小王3",18,"男");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        String str = JSON.toJSONString(list);

        return str;
    }

}
