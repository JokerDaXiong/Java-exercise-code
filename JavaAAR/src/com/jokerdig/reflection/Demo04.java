package com.jokerdig.reflection;

/**
 * @author Joker大雄
 * @data 2021/9/9 - 17:34
 **/
//测试类什么时候会初始化
public class Demo04 {
   static{
       System.out.println("main类被加载");
   }

    public static void main(String[] args) throws ClassNotFoundException {
        //主动调用
         Son son = new Son();
        //反射会产生主动引用
        Class.forName("com.jokerdig.reflection.Son");
        //不会产生类的引用方法
        System.out.println(Son.b);
        Son[] array = new Son[5];
        //常量不会引起类初始化
        System.out.println(Son.M);
   }
}

class Father{
    static int b=2;
    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static{
        System.out.println("子类被加载");
        m = 300;
    }
    static int m =100;
    static final int M=1;
}