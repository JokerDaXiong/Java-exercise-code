package com.jokerdig.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Joker大雄
 * @data 2022/8/23 - 11:11
 **/
//  Executors 工具类  3大方法
    // 使用了线程池之后，要使用线程池来创建线程
public class Demo01 {
    public static void main(String[] args) {
        // ExecutorService threadExecutor = Executors.newSingleThreadExecutor();// 单个线程
        // ExecutorService threadExecutor = Executors.newFixedThreadPool(3); // 创建固定线程池大小
        ExecutorService threadExecutor = Executors.newCachedThreadPool(); // 可伸缩的

        try {
            for (int i = 0; i < 10; i++) {
                threadExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池使用完，程序结束，关闭线程池
            threadExecutor.shutdown();
        }

    }
}
