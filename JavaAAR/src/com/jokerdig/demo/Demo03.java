package com.jokerdig.demo;

import java.lang.annotation.*;

/**
 * @author Joker大雄
 * @data 2021/9/6 - 21:28
 **/
//测试元注解
public class Demo03 {
    @MyAnnotation
    public void test(){
    }
}
//定义一个注释
//@Target 目标,表示注解能用在那些地方
@Target(value= {ElementType.METHOD,ElementType.TYPE})
//Retention 表示注解在什么地方还有效
//runtime>class>source
@Retention(value= RetentionPolicy.RUNTIME)
//Documented  表示是否将我们的注解生成在Javadoc中
@Documented
//InHerited  子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}

