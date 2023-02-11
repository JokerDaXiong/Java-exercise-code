package com.jokerdig.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/29 - 11:21
 **/
public class Demo02 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        new Thread(()->{
            phone.sms();
        },"A").start();
        new Thread(()->{
            phone.sms();
        },"B").start();
    }

}
class Phone1{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock(); // 第一把锁  上锁和解锁必须配锁，否则会产生死锁
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call(); // 这里也有锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        lock.lock();// 第二把锁
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
