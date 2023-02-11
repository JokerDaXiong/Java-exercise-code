package com.opp.demo01;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 20:20
 **/
//继承
public class Person01 extends Persons {
    private String name1="子类super";

    public void test(String name1){
        System.out.println(name1);//传输的值
        System.out.println(this.name1);//当前类的值
        System.out.println(super.name1);//父类的值
    }
    public void print(){
        System.out.println("子类print方法");
    }
    //方法也可访问
    public void test1(){
        print();
        this.print();
        super.print();
    }

    public Person01() {
       //隐藏代码：调用了父类的无参构造
        super();//这里默认隐藏了，必须在第一行
        System.out.println("person01");
    }
}
