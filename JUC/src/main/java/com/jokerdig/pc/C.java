package com.jokerdig.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 9:53
 **/
public class C {
    // A执行后调用B，B执行后调用C，C执行后调用A
    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(()->{
            for(int i =0;i<5;i++){
                data2.printA();
            }
        },"A").start();
        new Thread(()->{
            for(int i =0;i<5;i++){
                data2.printB();
            }
        },"B").start();
        new Thread(()->{
            for(int i =0;i<5;i++){
                data2.printC();
            }
        },"C").start();
    }
}
// 资源类
class Data2{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;  // 1A,2B,3C
    public void printA(){
        lock.lock();
        try {
            // 业务代码
            while(num!=1){
                // 等待
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"->A");
            // 唤醒
            num=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            // 业务代码
            while(num!=2){
                // 等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"->B");
            // 唤醒
            num=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            // 业务代码
            while(num!=3){
                // 等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"->C");
            // 唤醒
            num=1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
