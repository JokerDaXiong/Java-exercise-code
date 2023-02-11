package com.jokerdig.method;

/**
 * @author Joker大雄
 * @data 2021/8/12 - 20:45
 **/
public class Demo03 {
    public static void main(String[] args) {
        //5!  阶乘
        System.out.println(f(5));

    }
    public static int f(int n){
        if(n==1){
            return 1;
        }else{
            return n*f(n-1);
        }
    }
}
