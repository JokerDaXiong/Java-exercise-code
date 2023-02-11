package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 20:17
 **/
public class Demo13 {
    public static void main(String[] args) {
        //打印三角形  5行
        for (int i = 1; i <= 5; i++) {

            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        //打印三角形 5行  第二种方法
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <=5-i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <=2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
