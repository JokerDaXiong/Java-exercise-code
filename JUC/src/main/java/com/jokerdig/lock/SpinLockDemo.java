package com.jokerdig.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Joker大雄
 * @data 2022/8/29 - 11:33
 **/
// 自旋锁
public class SpinLockDemo {
    // int 0   Thread null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==> myLock");
        // 自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    // 解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==> myUnLock");
        atomicReference.compareAndSet(thread,null);
    }
}
