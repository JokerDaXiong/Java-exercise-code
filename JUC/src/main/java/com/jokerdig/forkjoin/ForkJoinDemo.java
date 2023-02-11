package com.jokerdig.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author Joker大雄
 * @data 2022/8/25 - 11:29
 **/
// 求和计算任务
public class ForkJoinDemo extends RecursiveTask<Long> {
    /*
        如何使用ForkJoin
        1. ForkJoinPool 通过它来执行
        2. 计算任务 ForkJoinPool.execute(ForkJoinTask task)
        3. 计算类继承ForkJoinTask ->RecursiveTask、RecursiveAction
     */
    private Long start;
    private Long end;
    // 临界值
    private Long temp = 10000L;
    // 构造器
    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    // 计算方法
    @Override
    protected Long compute() {
        if((end-start)<temp){
            Long sum=0L;
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else{
            // 分支合并计算 ForkJoin
            long middle = (start+end)/2; // 中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork(); // 拆分任务，把任务放入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();
            return task1.join()+task2.join(); // 返回计算结果
        }
    }
}
