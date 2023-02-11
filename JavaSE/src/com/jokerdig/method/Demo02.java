package com.jokerdig.method;

/**
 * @author Joker大雄
 * @data 2021/8/12 - 19:54
 **/
public class Demo02 {
    //main方法
    public static void main(String[] args) {
        //int max = max(20,30);
        double max = max(20,30);
        System.out.println(max);
    }
    //比大小
    public static double max(double number1,double number2){
        double result =0;
        if(number1>number2){
            result = number1;
        }else if(number1<number2){
            result= number2;
        }else{
            System.out.println("二者相等");
            return 0;
        }
        return result;
    }

    //比大小
    public static int max(int number1,int number2){
       int result =0;
        if(number1>number2){
            result = number1;
        }else if(number1<number2){
            result= number2;
        }else{
            System.out.println("二者相等");
            return 0;
        }
        return result;
    }

}
