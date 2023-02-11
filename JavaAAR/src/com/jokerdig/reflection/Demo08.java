package com.jokerdig.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Joker大雄
 * @data 2021/9/10 - 19:40
 **/
//分析性能问题
public class Demo08 {

    //普通方式调用
    public static void test1(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行10000次需要"+(endTime-startTime)+"ms");
    }

    //反射方式调用
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法执行10000次需要"+(endTime-startTime)+"ms");
    }
    //放射方式调用，关闭检查
    public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(false);//关闭检测
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
           getName.invoke(user,null);

        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测反射方法执行10000次需要"+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1();
        test2();
        test3();
    }
}
