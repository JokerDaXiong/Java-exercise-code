package com.jokerdig.oop;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 18:01
 **/
public class Demo02 {
    //静态方法 static
    //非静态
    public static void main(String[] args) {

     //  Student student = new Student();
     //  student.say();
      int a= add(1,2);
      System.out.println(a);
      //值传递
      int b = 1;
      System.out.println(b);//1
      Demo02.change(b);
      System.out.println(b);//1

      //引用传递
        Person person = new Person();
        System.out.println(person.name);//null
        Demo02.change(person);
        System.out.println(person.name);//引用传递值
    }
    //static和类一起加载
    public static void a(){
        //b();
    }
    //类实例化之后才存在
    public void b(){
    }
    //形参
    public static int add(int a,int b){
        return a+b;
    }
    //传递值,返回值为空
    public static void change(int b){
        b=10;
    }

    public static void change(Person person){
        //person是一个对象，修改类Person类里的全局变量name
        person.name="引用传递值";
    }
}
//定义了一个Person类，有一个属性 name
class Person{
    String name;//null
}