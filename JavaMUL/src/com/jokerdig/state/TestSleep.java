package com.jokerdig.state;

import com.jokerdig.demo1.TestThread4;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 14:00
 **/
//模拟网络延时来放大问题发生
public class TestSleep implements Runnable{
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                //没有票，退出
                break;
            }
            //模拟延时
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