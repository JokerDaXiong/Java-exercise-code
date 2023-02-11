package com.jokerdig.test;

import com.jokerdig.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/11 - 11:52
 **/
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 在getBean的时候就已经创建对象了
//        User user =(User) context.getBean("user");
//        user.show();
        User usert = (User) context.getBean("userT2");
        usert.show();


    }
}
