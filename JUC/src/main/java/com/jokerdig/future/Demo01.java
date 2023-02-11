package com.jokerdig.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/25 - 12:23
 **/
/*
    异步调用：CompletableFuture
        异步执行
        成功回调
        失败回调
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        // 发起请求 没有返回值的异步回调
//        CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync");
//        });
//        System.out.println("测试阻塞！");
//        // 阻塞获取执行结果
//        completableFuture.get();
        // 有返回值的异步回调
        CompletableFuture<Integer> completableFuture =CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync->Integer");
            // 添加异常，查看返回结果
            // int i =10/0;
            return 1024;
        });
        System.out.println(// 编译成功 whenComplete有两个参数，没有返回值
                completableFuture.whenComplete((t,u)->{
                    // 打印参数
                    System.out.println("t->"+t); // 正常的返回结果
                    System.out.println("u->"+u); // 异常信息
                    // 编译失败 exceptionally 有参数和返回值
                }).exceptionally((e)->{
                    // 打印消息
                    System.out.println(e.getMessage());
                    // 异常返回-1
                    return -1;
                }).get());
    }
}
