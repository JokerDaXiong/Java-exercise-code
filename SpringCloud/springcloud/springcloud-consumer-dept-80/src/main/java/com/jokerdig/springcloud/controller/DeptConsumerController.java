package com.jokerdig.springcloud.controller;

import com.jokerdig.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 15:10
 **/
@RestController
public class DeptConsumerController {
    // 消费者不会有service
    // RestTemplate 供我们调用
    // {url,实体:Map，Class<T> responseType}
    @Autowired
    private RestTemplate restTemplate; // 提供多种边界访问远程HTTP服务方法，简单的RestFul服务模板

    // private static final String REST_URL_PREFIX="http://localhost:8001";
    // Ribbon实现
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";
    // 添加
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add/",dept,Boolean.class);
    }

    // 通过id查询
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    // 查询
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }



}
