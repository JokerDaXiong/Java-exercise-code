package com.jokerdig.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/26 - 11:10
 **/
public class JMMDemo {
    // 增加关键字volatile
    private volatile static int number = 0;
    public static void main(String[] args) { // main线程

        new Thread(()->{// 线程1
            while(number==0){

            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 虽然number值改变，并返回到主内存,但是线程1还没接收到新的值，所以一直在循环
        number=1;
        System.out.println(number);

    }


}
