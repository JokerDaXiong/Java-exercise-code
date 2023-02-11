package com.jokerdig.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/29 - 11:45
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 自定义自旋锁
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.myUnLock();
            }

        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.myUnLock();
            }
        },"B").start();
    }
}
