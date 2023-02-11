package com.jokerdig.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 10:49
 **/
public class Demo05 {
         /*
           增加两个静态的同步方法
        */
    // 执行结果：
    public static void main(String[] args) {
        Phone5 phone = new Phone5();
        Phone5 phone2 = new Phone5();
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
class Phone5{
    // synchronized 锁的对象是方法的调用者
    // 发短信 static方法 锁的是Class
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    // 打电话 没有static 锁的是对象
    public synchronized void call(){
        System.out.println("打电话");
    }
}


