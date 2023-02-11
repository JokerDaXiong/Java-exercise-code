package com.opp.demo06;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 14:19
 **/
public class Outer {
    private int id;
    public void out(){
        System.out.println("外部类");
    }
    //全员内部类
    public class Inner{
        public void in(){
            System.out.println("内部类");
        }
        //获得外部类的私有属性
        public void getId(){
            System.out.println(id);
        }
    }
    //局部内部类
    public void method(){
        class Inner{
            public void in(){

            }
        }
    }

    public static void main(String[] args) {
        //没有名字初始化类,不用将实例保存到变量中
        //匿名内部类
        new Apple().eat();

       UserService us = new UserService(){
            //重写方法
            @Override
            public void hello() {

            }
        };
    }

}
//一个java类中可以有多个class类，但只能有一个public的类
class A{
}
//匿名内部类
class Apple{
    public void eat(){
        System.out.println("1");
    }
}
interface UserService{
    void hello();
}
