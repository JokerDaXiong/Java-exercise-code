package com.jokerdig.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author Joker大雄
 * @data 2022/8/25 - 11:47
 **/
// 计算10亿之和
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // test1(); // sum=500000000500000000 花费时间=7643
        // test2(); // sum=500000000500000000 花费时间=7650
        // test3(); // sum=500000000500000000 花费时间=227
    }

    // 方法一 直接使用for循环计算
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long  i = 1L; i <= 10_0000_0000; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费时间="+(end-start));
    }

    // 方法二 使用ForkJoin计算
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        // 新建任务
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        // 提交
        ForkJoinTask<Long> submit = pool.submit(task);
        // 计算结果
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费时间="+(end-start));
    }

    // 方法三 使用并行流计算
    public static void test3(){
        long start = System.currentTimeMillis();
        // 使用Stream并行流
        Long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费时间="+(end-start));
    }

}
