package com.jokerdig.springcloud.controller;

import com.jokerdig.springcloud.pojo.Dept;
import com.jokerdig.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    DeptClientService deptClientService = null;;

    // Feign实现

    // 添加
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }

    // 通过id查询
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.queryById(id);
    }

    // 查询
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return this.deptClientService.queryAll();
    }
}
