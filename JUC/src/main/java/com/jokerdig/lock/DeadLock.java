package com.jokerdig.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/29 - 11:54
 **/
public class DeadLock {
    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";
        // 锁A尝试获取锁B
       new Thread(new myThread(lockA,lockB),"T1").start();
        // 锁B尝试获取锁A
       new Thread(new myThread(lockB,lockA),"T2").start();
    }
}
class myThread implements Runnable{

    private String lockA;
    private String lockB;

    public myThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread()+"lock:"+lockA+"get==>"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread()+"lock:"+lockB+"get==>"+lockA);
            }
        }

    }
}
