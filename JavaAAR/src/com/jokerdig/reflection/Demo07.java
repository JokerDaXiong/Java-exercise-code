package com.jokerdig.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Joker大雄
 * @data 2021/9/10 - 19:06
 **/
//动态的创建对象，通过反射
public class Demo07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.jokerdig.reflection.User");

        //构造一个对象
        User user =(User) c1.newInstance();//调用无参构造器(过时)
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, String.class, int.class);
        User user1 =(User) constructor.newInstance("张三", "123", 20);
        System.out.println(user1);

        //通过反射调用方法
        User user3 =(User) c1.newInstance();//调用无参构造器
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke:激活
        //用法：(对象,"方法的值")
        setName.invoke(user3,"张三");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 =(User) c1.newInstance();//调用无参构造器
        Field name =c1.getDeclaredField("name");
        //关掉权限检测,来访问私有属性
        name.setAccessible(true);//关闭检测,默认为false
        name.set(user4,"张三2");
        System.out.println(user4.getName());
    }
}
