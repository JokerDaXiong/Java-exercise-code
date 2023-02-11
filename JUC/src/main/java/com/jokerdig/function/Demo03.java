package com.jokerdig.function;

import java.util.function.Consumer;

/**
 * @author Joker大雄
 * @data 2022/8/24 - 10:37
 **/
// Consumer 消费型接口 传入参数，没有返回值
public class Demo03 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        // 简化
//        Consumer<String> consumer = (str)->{
//            System.out.println(str);
//        };
        // 再简化
        Consumer<String> consumer = (str)-> System.out.println(str);
        consumer.accept("jokerdig");
    }
}
