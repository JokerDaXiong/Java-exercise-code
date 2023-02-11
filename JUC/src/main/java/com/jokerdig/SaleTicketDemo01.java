package com.jokerdig;

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
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发，多线程操作同一个资源类
        Ticket ticket = new Ticket();
        // @FunctionalInterface 函数表达式接口
        // 使用lambda表达式(参数)->{代码}
        new Thread(()->{
            for(int i = 1;i<40;i++){
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for(int i = 1;i<40;i++){
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for(int i = 1;i<40;i++){
                ticket.sale();
            }
        },"C").start();
    }
}
// 资源类 OOP
class Ticket{
    // 属性 方法
    private int number = 30;
    // 卖票 传统方式解决
    // synchronized 本质：锁 队列
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"票，剩余："+number);
        }
    }
}

