package com.joekrdig.test;

import com.jokerdig.config.SpringConfig;
import com.jokerdig.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/14 - 14:13
 **/
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

       User getUser = (User) context.getBean("getUser");

        System.out.println(getUser.getName());

    }
}
