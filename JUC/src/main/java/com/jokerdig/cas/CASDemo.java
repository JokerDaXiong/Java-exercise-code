package com.jokerdig.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 11:45
 **/
public class CASDemo {
    // CAS compareAndSet：比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2022);
        // public final boolean compareAndSet(int expect, int update)
        // 如果期望的值达到，就更新为新的值
        atomicInteger.compareAndSet(2022,2023);
        System.out.println(atomicInteger.get()); // 结果2023
        // 这里没有更新为2021
        atomicInteger.compareAndSet(2022,2021);
        System.out.println(atomicInteger.get()); // 结果2023



    }


}
