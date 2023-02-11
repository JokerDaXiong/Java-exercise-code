package com.jokerdig.operator;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 20:07
 **/
public class Demo01 {
    public static void main(String[] args) {
        //二元运算符
        int a = 10;
        int b = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / (double) b);


        //拓展
        long c = 23123123213L;
        int d = 123;
        short e = 10;
        byte f = 8;

        System.out.println(c + d + e + f);//Long
        System.out.println(d + e + f);//int
        System.out.println(e + f);//int
        //============================

        //关系运算符返回结果：正确，错误，布尔值
        int a1 = 10;
        int b1 = 20;
        int c1 = 21;
        System.out.println(a1>b1);
        System.out.println(a1<b1);
        System.out.println(a1==b1);
        System.out.println(a1!=b1);
        System.out.println(c1%a1);
        //
    }
}
