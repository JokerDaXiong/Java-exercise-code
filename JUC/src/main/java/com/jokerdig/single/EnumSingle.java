package com.jokerdig.single;

import java.lang.reflect.Constructor;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 11:25
 **/
// enum 枚举 本身也是一个Class
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }



}
class  Test{
    public static void main(String[] args) throws Exception {
        // 测试反射破坏枚举
        EnumSingle instance1 = EnumSingle.INSTANCE;
        // 通过反编译得到源码，分析出 这里并不是无参构造，而是一个有参构造，并且又两个参数String和int
        // Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(null);
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingle instance2 = constructor.newInstance();
        // com.jokerdig.single.EnumSingle.<init>() 没有这个空参构造方法
        System.out.println(instance1);
        System.out.println(instance2);
        // 再次运行 得出结果： Cannot reflectively create enum objects
        // 无法以反射方式创建枚举对象
        // 从而验证枚举无法被反射破坏
    }
}
