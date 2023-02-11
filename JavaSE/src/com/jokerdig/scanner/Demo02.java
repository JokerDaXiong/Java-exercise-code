package com.jokerdig.scanner;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 15:10
 **/
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.println("请输入整数：");
        if(scanner.hasNextInt()){
            i=scanner.nextInt();
            System.out.println("整数数据："+i);
        }else{
            System.out.println("输入的不是整数");
        }

        System.out.println("请输入小数：");
        if(scanner.hasNextFloat()){
            f=scanner.nextFloat();
            System.out.println("小数数据："+f);
        }else{
            System.out.println("输入的不是小数");
        }

        scanner.close();
    }
}
