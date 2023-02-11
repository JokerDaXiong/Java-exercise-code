package com.jokerdig.test;

import com.jokerdig.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/14 - 13:32
 **/
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User)context.getBean("user");

        System.out.println(user.getName());

    }
}
