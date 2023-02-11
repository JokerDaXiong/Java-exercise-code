package com.jokerdig.struct;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 17:12
 **/
public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //switch练习
       // char grade = 'A';
        String grade ="A";
        System.out.println("请输入成绩等级：");
        grade=scanner.next();
        scanner.close();

        //反编译  java----class(字节码文件) ----反编译(IDEA)方法：直接把class文件放到IDEA项目
        switch(grade){//这里String类型通过.hashCode找到相应的数字编码
            case "A":
                System.out.println("优秀");
                break;
            case "B":
                System.out.println("良好");
                break;
            case "C":
                System.out.println("一般");
                break;
            case "D":
                System.out.println("再接再厉");
                break;
            case "E":
                System.out.println("挂科");
                break;
            default:
                System.out.println("未知等级");
        }

    }
}
