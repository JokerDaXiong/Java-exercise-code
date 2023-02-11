package com.jokerdig.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Joker大雄
 * @data 2022/8/20 - 10:56
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 例子：集齐7颗龙珠召唤神龙
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙！");
        });

        for(int i =1;i<=7;i++){
            final int temp = i; // 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
            // lambda表达式无法直接操作i
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await(); //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }


}
