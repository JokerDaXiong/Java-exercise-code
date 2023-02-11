package com.jokerdig.function;

import java.util.function.Function;

/**
 * @author Joker大雄
 * @data 2022/8/24 - 10:11
 **/
// Function 函数型接口 有一个输入参数，有一个输出
// 只要是函数式接口，可以使用lambda表达式简化
public class Demo01 {
    public static void main(String[] args) {
        // 工具类  输出输入的值
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        // lambda 表达式 简化
        // Function function = (str)->{return str;};
        // 再简化
        Function function = (str)->str;
        System.out.println(function.apply("jokerdig"));

    }
}
