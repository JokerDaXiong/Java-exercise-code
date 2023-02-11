package com.jokerdig.scanner;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 14:56
 **/
public class Demo01 {
    public static void main(String[] args) {
      //创建一个扫描器对象，用于接收键盘数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式接收：");

        //判断用户有没有输入字符串
        //hasNextLine 为判断接收的内容是否有下一行
        if(scanner.hasNext()){
            //使用next接收
            String str = scanner.next();
            System.out.println("输出内容："+str);
        }
        //使用完关闭io流
        scanner.close();
    }
}
