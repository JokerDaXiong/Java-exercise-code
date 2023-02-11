package com.jokerdig.springcloud.controller;

import com.jokerdig.springcloud.pojo.Dept;
import com.jokerdig.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 11:29
 **/
// 提供Restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw new RuntimeException("id=>"+id+",该用户不存在");
        }
        return dept;
    }
    // 备选方案
    public Dept hystrixGet(@PathVariable("id")Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+",该用户不存在")
                .setDb_source("no this database in MySQL");
    }
}
