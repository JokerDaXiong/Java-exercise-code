package com.jokerdig.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/20 - 11:07
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 例子：抢车位
        // 线程数量 停车位
        Semaphore semaphore = new Semaphore(3);

        for (int i=1;i<=6;i++){
            new Thread(()->{
                // acquire() 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(2); // 假设停了两秒
                    System.out.println(Thread.currentThread().getName()+"离开了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // release() 释放
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
