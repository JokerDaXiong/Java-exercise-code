package com.jokerdig.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author Joker大雄
 * @data 2022/8/20 - 10:45
 **/
// 计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 倒计时 总数是5
        CountDownLatch downLatch = new CountDownLatch(5);

        for (int i= 1;i<=5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"->end");
                downLatch.countDown(); // 减一
            }).start();
        }
        downLatch.await();// 等待计数器归零在向下执行

        System.out.println("计数器已经归零");



    }


}
