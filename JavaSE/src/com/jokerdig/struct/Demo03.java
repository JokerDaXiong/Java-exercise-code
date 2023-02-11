package com.jokerdig.struct;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 16:29
 **/
public class Demo03 {
    public static void main(String[] args) {
        //考试分数大于60就及格，小于60就不及格
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();

        if(score>60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }

        scanner.close();
    }
}
