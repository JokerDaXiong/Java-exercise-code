package com.jokerdig.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Joker大雄
 * @data 2021/9/7 - 16:34
 **/
//自定义注解
public class Demo04 {
    //定义了默认值就可不传参，否则不传参会报错
    @MyAnnotation1(name="自定义注解")
    public void test(){}
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1{
    //注解的参数：参数类型+参数名()
    String name() default "";
    int age() default 0;
    int id() default -1;//默认值-1代表不存在
    String[] schools() default{"家里蹲大学"};
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();//value可以不传参
}
