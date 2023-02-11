package com.jokerdig.test;

import com.jokerdig.service.UserService;
import com.jokerdig.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/21 - 15:10
 **/
public class SpringTest {
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 动态代理的是接口
        UserService userService =(UserService) context.getBean("userService");

        userService.add();
        userService.query();
    }
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");

        // 动态代理的是接口
        UserService userService =(UserService) context.getBean("userService");

        userService.add();
        userService.query();
    }
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        // 动态代理的是接口
        UserService userService =(UserService) context.getBean("userService");

        userService.add();
        userService.query();
    }
}
