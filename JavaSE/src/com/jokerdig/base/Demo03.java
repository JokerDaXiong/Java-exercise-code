package com.jokerdig.base;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 16:20
 **/
public class Demo03 {
    public static void main(String[] args) {
        int i = 128;
        byte b = (byte)i; //造成内存溢出
        double c = i;
        //强制转化 (类型)变量名  高->低
        //自动转化  低->高
        System.out.println(i);
        System.out.println(b);
        System.out.println(c);
        /*
         注意点：
          1. 不能对布尔值进行转化
          2. 不能把对象类型转化为不相干的类型
          3. 再把高容量转换到低容量的时候，需要强制转化
          4. 转换的时候可能存在内存溢出或精度问题
         */

        System.out.println("=================");
        System.out.println((int)23.6);
        System.out.println((int)-45.99f);

        System.out.println("=================");
        char d = 'a';
        int e =d+1;
        System.out.println(e);//98
        System.out.println((char)e); //b

        //操作比较大的数字，注意溢出问题
        //jdk7特性  数字之间可以用下划线分割
        int money = 10_0000_0000;
       // System.out.println(money);
        int years = 20;
        int total = money*years; //-1474836480 溢出
        System.out.println(total);
        long total2 = money*years;//默认是int 在转换前就已经溢出了
        System.out.println(total2);
        long total3 = money*(long)years;//单独对可能溢出的内容进行转换
        System.out.println(total3);

        // L多用大写   l





    }
}
