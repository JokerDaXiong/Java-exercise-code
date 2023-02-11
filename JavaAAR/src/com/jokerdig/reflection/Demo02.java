package com.jokerdig.reflection;

import java.lang.annotation.ElementType;

/**
 * @author Joker大雄
 * @data 2021/9/8 - 14:13
 **/
//所有类型的class
public class Demo02 {
    public static void main(String[] args) {
        Class c1 = Object.class;//类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//一维数组
        Class c4 = int[][].class;//二位数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;//基本数据类型
        Class c8 = void.class;//void
        Class c9 = Class.class;//Class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        int []a = new int[10];
        int []b = new int[100];
        //只要元素类型和维度一样，就是同一个Class
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
