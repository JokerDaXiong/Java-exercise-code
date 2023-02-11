package com.jokerdig.test;

import com.jokerdig.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/13 - 13:30
 **/
public class BeanTest {
    @Test
    public void test(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("beans.xml");

        Person person =(Person)context.getBean("person");

        person.getDog().shout();
        person.getCat().shout();


    }
    @Test
    public void test2(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("beans2.xml");

        Person person =(Person)context.getBean("person");

        person.getDog().shout();
        person.getCat().shout();
    }
}
