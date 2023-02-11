package com.jokerdig.oop;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 18:45
 **/
public class Persons {
    //一个类即使什么都不写，也会存在一个方法，为构造器
    String name;
    protected String name1="父类super";
    //实例化初始值
    /*
       1.使用new关键字，本质是在调用构造器
       2.用来初始化值
       alt+ins(insert) 生成构造器快捷键
     */

    /*
     构造器
       1.和类名相同
       2.没有返回值
     作用：
       1.new 本质在调用构造方法
       2.初始画对象的值
     注意：
       定义有参构造后，如果想用无参，显示的定义一个无参构造
     */


    //无参构造
    public Persons(){
       // this.name = "构造器测试名字";
    }

    //有参构造  一旦定义有参构造，无参构造就必须显示定义
    public Persons(String name){
        this.name = name;
    }
    public void print(){
        System.out.println("父类print");
    }
}
