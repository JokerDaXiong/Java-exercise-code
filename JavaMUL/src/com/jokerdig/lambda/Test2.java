package com.jokerdig.lambda;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 13:14
 **/
public class Test2 {

    public static void main(String[] args) {
        //lambda表达式简化
       ILove love =(int a)->{
            System.out.println("I love you"+a);
        };
        love.love(1);
        //1.简化参数类型
        love =(a)->{
            System.out.println("I love you"+a);
        };
        love.love(2);
        //2.简化括号
        love = a ->{
            System.out.println("I love you"+a);
        };
        love.love(3);
        //3.简化大括号
        love = a -> System.out.println("I love you"+a);;
        love.love(4);

    }
}
interface  ILove{
    void love(int a);
}
