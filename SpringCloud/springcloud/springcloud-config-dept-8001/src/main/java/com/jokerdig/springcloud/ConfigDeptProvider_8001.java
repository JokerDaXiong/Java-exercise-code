package com.jokerdig.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 11:34
 **/
// 启动类
@SpringBootApplication
@EnableEurekaClient //开启eureka
@EnableDiscoveryClient // 服务发现
public class ConfigDeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigDeptProvider_8001.class,args);
    }


}
