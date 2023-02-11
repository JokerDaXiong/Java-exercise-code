package com.jokerdig.reflection;

/**
 * @author Joker大雄
 * @data 2021/9/8 - 14:44
 **/
public class Demo03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /*
         1.加载到内存，会产生一个类对应class对象
         2.链接，连接结束后m=0
         3.初始化
           <clinit>(){
                System.out.println("A类静态代码块初始化");
                m=300;
           }
         */
    }
}
class A{
    static{
        System.out.println("A类静态代码块初始化");
        m=300;
    }
    static int m=100;
    public A(){
        System.out.println("A类的无参构造初始化");
    }
}

