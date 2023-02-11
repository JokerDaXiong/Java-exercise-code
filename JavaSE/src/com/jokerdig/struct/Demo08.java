package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 18:44
 **/
public class Demo08 {
    public static void main(String[] args) {
//        int a = 1;//初始化条件
//
//        while(a<=100){
//            System.out.println(a);
//            a+=2;//迭代
//        }
//        System.out.println("while循环结束");
//
//        for(int i=1;i<=100;i++){
//            System.out.println(i);
//        }
//        //100.for
//        System.out.println("for循环结束");

        //练习1 计算0~100之间的奇数和偶数的和
        int oddSum = 0;
        int evenSum =0;
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                oddSum+=i;
            }else{
                evenSum+=i;
            }
        }
        System.out.println("奇数的和"+oddSum);
        System.out.println("偶数的和"+evenSum);
    }
}
