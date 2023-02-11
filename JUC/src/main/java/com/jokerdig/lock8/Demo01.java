package com.jokerdig.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 10:13
 **/
public class Demo01 {
    // 执行结果： 打电话 发短信
    public static void main(String[] args) {
        // 两个对象调用 锁之间互不影响
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();
        // 休息1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}

class Phone{
    // synchronized 锁的对象是方法的调用者
    // 两个方法是同一个锁，谁先拿到谁先执行
    // 在同一把锁释放之前，另一个方法都不会执行
    // 发短信
    public synchronized void sendSms(){
        // 等待四秒
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    // 打电话
    public synchronized void call(){
        System.out.println("打电话");
    }
}
