package com.jokerdig.tvolatile;

import javax.xml.ws.soap.Addressing;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joker大雄
 * @data 2022/8/26 - 11:22
 **/
// 非原子性
public class VDemo {
    // 原子类  AtomicInteger
    private volatile static AtomicInteger number = new AtomicInteger();

    public static void add(){
        // number++; // 非原子性操作
        number.getAndIncrement(); //AtomicInteger+1方法 底层CAS
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while(Thread.activeCount()>2){ // main  gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+number);
    }
}
