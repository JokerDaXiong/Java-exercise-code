package com.jokerdig.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 10:39
 **/
public class Demo04 {
    /*
        增加两个静态的同步方法
     */
    // 执行结果：   发短信   打电话
    public static void main(String[] args) {
        // 两个对象 都是两个同步方法
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();
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
// Phone4 有唯一的一个Class对象
class Phone4{
    // synchronized 锁的对象是方法的调用者
    // static 静态方法
    // 类一加载就存在了， 锁的是Class->模板
    // 发短信 添加static
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    // 打电话 添加static
    public static synchronized void call(){
        System.out.println("打电话");
    }
}


