package com.jokerdig.pool;

import java.util.concurrent.*;

/**
 * @author Joker大雄
 * @data 2022/8/23 - 11:39
 **/
// 手动创建线程池
public class Demo02 {
    public static void main(String[] args) {
        /*
            模拟银行业务：
            默认开启2个窗口
            最大有5个窗口
            候客区有3个座位
         */
        Runtime.getRuntime().availableProcessors(); // 获取CPU核数

        ExecutorService threadExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // new ThreadPoolExecutor.AbortPolicy()); // 银行满员，还有人进入，不处理这个人，抛出异常
                // new ThreadPoolExecutor.CallerRunsPolicy()); // 哪来的去哪
                // new ThreadPoolExecutor.DiscardPolicy()); // 队列满了，丢掉任务，不会抛出异常
                 new ThreadPoolExecutor.DiscardOldestPolicy()); // 队列满了，尝试和最早的竞争，不会抛出异常
        try {
            // 最大承载 队列+max值->3+8=8人 超过就会被拒绝策略接收，从而抛出异常
            for (int i = 1; i <=9; i++) {
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
