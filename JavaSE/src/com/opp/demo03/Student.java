package com.opp.demo03;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 13:21
 **/
//static
public class Student {
    private static int age;//静态变量
    private double score;//非静态变量

    public void run(){

    }
    public static void go(){

    }

    public static void main(String[]args){
        Student sq = new Student();

        System.out.println(Student.age);
        System.out.println(sq.age);
        System.out.println(sq.score);

        Student.go();//直接调用静态方法
    }
}
