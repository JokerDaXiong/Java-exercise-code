package com.jokerdig.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 12:59
 **/
// 解决ABA问题
public class ABA {
    public static void main(String[] args) {
        // AtomicInteger atomicInteger = new AtomicInteger(2022);
        // 原子引用
        // Integer包装类 -127~127之间，超过就不会复用该对象
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(23,1);
        // 新建两个线程
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("A1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改的值
            atomicStampedReference.compareAndSet(23, 22, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);

            System.out.println("A2=>"+atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(22, 23, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            System.out.println("A3=>"+atomicStampedReference.getStamp());
        },"A").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("B1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 期望的值
            System.out.println(atomicStampedReference.compareAndSet(23, 66, stamp, stamp + 1));
            System.out.println("B2=>"+atomicStampedReference.getStamp());
        },"B").start();


    }
}
