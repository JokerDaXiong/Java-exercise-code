package com.jokerdig.syn;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 12:07
 **/
//不安全的买票
    //线程不安全，有复数，有重复
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小王").start();
        new Thread(buyTicket,"小李").start();
        new Thread(buyTicket,"黄牛").start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNums = 10;
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronize 同步方法，锁的时this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}