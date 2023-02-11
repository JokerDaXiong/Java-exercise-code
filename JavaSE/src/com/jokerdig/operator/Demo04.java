package com.jokerdig.operator;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 20:56
 **/
public class Demo04 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a+=b;  //a=a+b
        System.out.println(a);
        a-=b;  //a=a-b
        System.out.println(a);

        //字符串连接符  +  ,  String
        System.out.println(""+a+b);//先拼接
        System.out.println(a+b+"");//先运算

        //三元运算符
        //  x ? y :z
        //如果x== true, 则结果为y,否则结果为z

        int score = 80;
        String type = score<60?"不及格":"及格";
        System.out.println(type);
    }
}
