package com.jokerdig.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Joker大雄
 * @data 2022/5/21 - 14:49
 **/
public class Log implements MethodBeforeAdvice {

    // method:要执行的目标对象的方法
    // args:参数
    // target:目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");




    }
}
