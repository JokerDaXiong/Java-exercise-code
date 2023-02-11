package com.jokerdig;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/16 - 14:14
 **/
// 基本售票例子
    /*
        真正的多线程开发
        线程就是一个单独的资源类，没有任何负数操作
        包含：属性、方法
     */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        // 并发，多线程操作同一个资源类
        Ticket2 ticket = new Ticket2();
        // @FunctionalInterface 函数表达式接口
        // 使用lambda表达式(参数)->{代码}
        new Thread(() -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "A").start();
        new Thread(() -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "B").start();
        new Thread(() -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "C").start();
    }
}

// Lock
/*
    1. new ReentrantLock();
    2. lock.lock();    加锁
    3. lock.unlock();  解锁
 */
class Ticket2{
    // 属性 方法
    private int number = 30;
    // 卖票 使用Lock
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();// 加锁
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"票，剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock(); // 解锁
        }
    }
}

