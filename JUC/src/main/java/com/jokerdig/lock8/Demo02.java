package com.jokerdig.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 10:25
 **/
public class Demo02 {
    // 执行结果：hello   发短信
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
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
            // 替换为普通方法hello
            phone.hello();
        },"B").start();
    }
}

class Phone2{
    // synchronized 锁的对象是方法的调用者
    // 两个方法是同一个锁，谁先拿到谁先执行
    // 在同一把锁释放之前，另一个方法都不会执行
    // 发短信
    public synchronized void sendSms(){
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
    // 没有synchronized 不受锁的限制，不是同步方法，会先执行
    public void hello(){
        System.out.println("hello");
    }
}
