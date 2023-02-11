package com.jokerdig.demo1;

/**
 * @author Joker大雄
 * @data 2021/8/20 - 19:29
 **/
//多个线程同时操作一个独享
    //买火车票例子
    //发现问题：多个线程操作同一个资源，线程不安全，数据紊乱(并发问题)
public class TestThread4 implements Runnable{

   //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                //没有票，退出
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 拿到了第"+ticketNums+" 票");
            ticketNums--;//售出票后减少
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
    }
}
