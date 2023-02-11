package com.jokerdig.springcloud.controller;

import com.jokerdig.springcloud.pojo.Dept;
import com.jokerdig.springcloud.service.DeptService;
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

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }
    @RequestMapping("dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @Autowired
    private DiscoveryClient client;
    // 注册进来的微服务
    @GetMapping("/dept/discovery")
    public Object Discovery(){
        // 获取微服务列表
        List<String> services = client.getServices();
        System.out.println("discovery->"+services);
        // 得到微服务信息 微服务id
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance : instances){
            System.out.println(
                    instance.getHost()+"\t"+
                            instance.getPort()+"\t"+
                            instance.getUri()+"\t"+
                            instance.getServiceId()
            );
        }
        return this.client;
    }
}
