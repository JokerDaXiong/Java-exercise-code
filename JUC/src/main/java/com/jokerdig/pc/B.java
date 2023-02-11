package com.jokerdig.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/17 - 10:22
 **/
/*
    线程之间通信问题：生产者和消费者问题
    线程交替执行 A  B 操作同一个变量  num=0
    等待唤醒 通知唤醒
    A num+1
    B num-1
 */
public class B {
    public static void main(String[] args) {
        Data1 data = new Data1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

// 判断等待 业务 通知
class Data1{ // 数字 资源类
    private int num = 0;
    // Lock锁
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    // +1
    public void increment() throws InterruptedException {
        try {
            lock.lock();
            // 使用while防止虚假唤醒
            while(num!=0){
                // 等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"->"+num);
            // 通知其他线程，+1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    // -1
    public void decrement() throws InterruptedException {
        try {
            lock.lock();
            // 使用while防止虚假唤醒
            while(num==0){
                // 等待
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"->"+num);
            // 通知其他线程，-1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
