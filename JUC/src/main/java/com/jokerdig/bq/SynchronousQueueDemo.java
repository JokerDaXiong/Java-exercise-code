package com.jokerdig.bq;

import java.sql.Time;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/23 - 10:55
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> blockQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 1");
                blockQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                blockQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                blockQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"->"+blockQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"->"+blockQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"->"+blockQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();




    }

}
