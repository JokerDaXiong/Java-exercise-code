package com.jokerdig.pc;

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
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}
// 判断等待 业务 通知
class Data{ // 数字 资源类
    private int num = 0;

    // +1
    public synchronized void increment() throws InterruptedException {
        // 使用while防止虚假唤醒
        while(num!=0){
            // 等待
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"->"+num);
        // 通知其他线程，+1完毕
        this.notifyAll();
    }
    // -1
    public synchronized void decrement() throws InterruptedException {
        // 使用while防止虚假唤醒
        while(num==0){
            // 等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"->"+num);
        // 通知其他线程，-1完毕
        this.notifyAll();
    }
}
