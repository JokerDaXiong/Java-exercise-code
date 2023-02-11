package com.jokerdig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/7/22 - 11:04
 **/
@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    // 没有实体类，数据库中的数据如何获取 ->Map
    @RequestMapping("/userList")
    public List<Map<String,Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    // 测试添加数据
    @RequestMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(id,name,pwd) values (5,'小胖','123')";
        jdbcTemplate.update(sql);
        return "add";
    }


}
