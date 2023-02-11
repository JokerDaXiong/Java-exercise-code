package com.jokerdig.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2021/8/23 - 10:52
 **/
//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 tk = new TestLock2();

        new Thread(tk).start();
        new Thread(tk).start();
        new Thread(tk).start();
    }
}

class TestLock2 implements  Runnable{
    int tickeN = 10;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();//加锁
                if(tickeN>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickeN--);
                }else{
                    break;
                }
            } finally {
                lock.unlock();//解锁
            }
        }
    }
}