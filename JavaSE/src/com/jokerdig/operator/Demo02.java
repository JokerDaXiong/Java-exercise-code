package com.jokerdig.operator;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 20:18
 **/
public class Demo02 {
    public static void main(String[] args) {
        // ++ --  自增 自减 一元运算符
        int a = 3;
        int b = a++; //执行完代码后，先赋值给b，再自增
        int c = ++a;//执行完代码后，先自增，在复制给c

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //拓展 幂运算 2^3  2*2*2=8 (基本数学运算，Java中用Math)
        System.out.println(Math.pow(2,3));//pow返回一个double类型
        //很多运算使用一些工具类来实现
    }
}
