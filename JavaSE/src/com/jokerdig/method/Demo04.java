package com.jokerdig.method;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/12 - 21:11
 **/
public class Demo04 {
    //简易计算器
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int oneN = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int twoN = scanner.nextInt();
        System.out.println("=================");
        System.out.println("1.加");
        System.out.println("2.减");
        System.out.println("3.乘");
        System.out.println("4.除");
        System.out.println("=================");
        System.out.println("输入数字选择计算方式");
        int put = scanner.nextInt();
        if(put==1){
            System.out.println("和为："+(oneN+twoN));
        }else if(put==2){
            System.out.println("差为："+(oneN-twoN));
        }else if(put==3){
            System.out.println("积为："+(oneN*twoN));
        }else if(put==4){
            System.out.println("商为："+(oneN/twoN));
        }else{
            System.out.println("输入不合法");
        }
    }
}
