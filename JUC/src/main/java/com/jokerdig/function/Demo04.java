package com.jokerdig.function;

import java.util.function.Supplier;

/**
 * @author Joker大雄
 * @data 2022/8/24 - 10:44
 **/
// Supplier 供给型接口  没有传入参数，只有返回值
public class Demo04 {
    public static void main(String[] args) {
//        Supplier supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 1024;
//            }
//        };
        // 简化
        // Supplier<Integer> supplier = ()->{return 1024;};
        // 再简化
        Supplier<Integer> supplier = () -> 1024;
        System.out.println(supplier.get());
    }
}
