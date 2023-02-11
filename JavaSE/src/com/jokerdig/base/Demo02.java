package com.jokerdig.base;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 15:55
 **/
public class Demo02 {
    public static void main(String[] args) {
        //整数拓展：    进制   二进制0b  十进制  八进制0  十六进制0x

        int i = 10;
        int i2 = 010; //八进制0
        int i3 = 0x10; //十六进制0x  0~9 A~F 16

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("====================================");
        //====================================
        //浮点数拓展？  银行业务怎么表示？$/￥
        // BigDecimal   数学工具类
        //====================================

        //float    有限   离散  舍入误差   大约  接近但不等于
        //double
        //最好完全用浮点数比较

        float f = 0.1f;  //0.1
        double d = 1.0/10;  //0.1
        System.out.println(f==d); //false
        System.out.println(f);
        System.out.println(d);

        float d1 = 2321312312321f;
        float d2 = d1+1;
        System.out.println(d1==d2); //ture

        //====================================
        //字符拓展？
        //====================================
        System.out.println("====================================");
        char c1 = 'A';
        char c2 = '人';
        System.out.println(c1);
        System.out.println((int)c1); //强制转换
        System.out.println(c2);
        System.out.println((int)c2); //强制转换

        //所有的字符本质还是数字
        // 编码  Unicode 表：(97=a 65=A) 2字节   0 - 65536 Excel  2^16 = 65536

        // U0000 UFFFF
        char c3 = '\u0062';
        System.out.println(c3); //b

        //转义字符
        // \t  制表符
        // \n  换行
        // ...
        System.out.println("Hello\nWorld");

        System.out.println("====================================");
        String sa = new String("hello world");
        String sb = new String("hello world");
        System.out.println(sa==sb);

        String sc = "hello world";
        String sd = "hello world";
        System.out.println(sc==sd);
        //对象 从内存分析

        //布尔值扩展
        boolean flag = true;
        if(flag==true){} //新手
        if(flag){} //老手
        //less is More  代码简介易读







    }
}
