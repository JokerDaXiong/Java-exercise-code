package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 19:01
 **/
public class Demo10 {
    public static void main(String[] args) {
        //打印九九乘法表
        for (int j = 1; j <= 9; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(j+"*"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }
    }
}
