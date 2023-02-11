package com.jokerdig.function;

import java.util.function.Predicate;

/**
 * @author Joker大雄
 * @data 2022/8/24 - 10:20
 **/
// Predicate 断定型接口：有一个输入参数，返回值只能是布尔值
public class Demo02 {
    public static void main(String[] args) {
//        Predicate predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//               return str.isEmpty();
//            }
//        };
        // lambda 表达式简化
        // Predicate<String> predicate = (str)->{return str.isEmpty();};
        // 再简化
        // Predicate<String> predicate = (str)->str.isEmpty();
        // 继续简化
        Predicate<String> predicate = String :: isEmpty;
        System.out.println(predicate.test("jokerdig"));
    }
}
