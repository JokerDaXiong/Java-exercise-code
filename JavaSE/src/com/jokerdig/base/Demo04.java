package com.jokerdig.base;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 16:53
 **/
public class Demo04 {

    //属性：变量
    //实例变量：从属于对象 不初始化为默认值
    String name;
    int age;

    //main方法
    public static void main(String[] args) {
        // int a b c
        int a=1,b=2,c=3;//不推荐这种写法
        String name = "game";
        char x = 'x';
        double pi = 3.14;
        //局部变量 必须声明和初始胡
        int i =10;
        System.out.println(i);

        //new 对象
        Demo04 demo4 = new Demo04();
        System.out.println(demo4.age);
    }

    //其他方法
    public void add(){

    }
}
