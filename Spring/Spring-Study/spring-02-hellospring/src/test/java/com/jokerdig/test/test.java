package com.jokerdig.test;

import com.jokerdig.test.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/5/11 - 11:00
 **/
public class test {

    @Test
    public void test(){
        // 允许容器从各种外部资源（如本地文件系统、Java 等）加载配置元数据
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 通过context拿到我们需要的值
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
