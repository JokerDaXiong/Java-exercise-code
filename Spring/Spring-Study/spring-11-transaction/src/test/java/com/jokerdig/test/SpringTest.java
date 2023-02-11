package com.jokerdig.test;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/25 - 11:25
 **/
public class SpringTest {
    @Test
    public void test12(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        List<User> users = userMapper.selectUser();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
