package com.jokerdig.struct;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 16:47
 **/
public class Demo04 {
    public static void main(String[] args) {
        //考试分数大于60就及格，小于60就不及格
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();
        if (score == 100) {
            System.out.println("恭喜满分");
        } else if (score < 100 && score >=90) {
            System.out.println("A级");
        }else if (score < 90 && score >=80) {
            System.out.println("B级");
        }else if (score < 80 && score >=70) {
            System.out.println("C级");
        }else if (score < 70 && score >=60) {
            System.out.println("D级");
        }else if (score < 60 && score >=0) {
            System.out.println("不及格");
        }else{
          System.out.println("成绩不合法");
        }
        scanner.close();
    }
}
