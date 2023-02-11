package com.jokerdig.struct;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 16:19
 **/
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入内容：");
        String s = scanner.nextLine();

        //equals:判断你字符传是否相等
        if(s.equals("Hello")){
            System.out.println("相等");
            return;
        }
        System.out.println("不等");
        scanner.close();
    }
}
