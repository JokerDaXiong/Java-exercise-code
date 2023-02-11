package com.jokerdig.config;

import com.jokerdig.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joker大雄
 * @data 2022/5/14 - 14:09
 **/
// 组件
@Configuration
// 扫描包
@ComponentScan("com.jokerdig.pojo")
public class SpringConfig {

    // 注册一个bean 就相当于我们之气那写的一个bean标签
    // 这个方法的名字 相当于bean标签中的id
    // 方法中的返回值  相当于bean标签中的class
    @Bean
    public User getUser(){
        return new User();
    }


}
