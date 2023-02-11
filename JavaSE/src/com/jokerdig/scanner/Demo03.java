package com.jokerdig.scanner;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 15:19
 **/
public class Demo03 {
    public static void main(String[] args) {
        //我们可以输入多个数字，并求其综合与平均数，每输入一个数字用回车确认，通过输入非数字结束输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据：");
        //和
        double sum =0;
        //计算输入了多少数字
        int m = 0;
        //通过循环判断你是否还有输入，并再里面对每一次进行求个
        while(scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m++;//m=++m  m=m+1
            sum = sum+x;
            System.out.println("你输入第"+m+"个数据，结果sum为"+sum);

        }
        System.out.println(m+"个数的和为"+sum);
        System.out.println(m+"个数的平均值是"+(sum / m));


        scanner.close();
    }
}
