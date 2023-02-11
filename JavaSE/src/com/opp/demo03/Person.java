package com.opp.demo03;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 13:24
 **/
public class Person {
    {
        //匿名代码块
        System.out.println("匿名代码块");
    }
    static{
        //静态代码块,只执行一次
        System.out.println("静态代码块");
    }
    public Person(){
        //构造方法
        System.out.println("构造方法");
    }
    public static void main(String[]args){
        Person person = new Person();
        System.out.println("===========");
        Person person1 = new Person();

    }
}
