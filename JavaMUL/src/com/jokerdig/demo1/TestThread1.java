package com.jokerdig.demo1;

/**
 * @author Joker大雄
 * @data 2021/8/20 - 18:32
 **/
//创建线程方式
public class TestThread1 extends Thread{
    @Override
    public void run(){
        //run方法
        for (int i = 0; i < 20; i++) {
            System.out.println("在看代码"+i);
        }
    }

    public static void main(String[] args) {
        //main方法
        TestThread1 testThread1 = new TestThread1();
        //调用start()方法i
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("学习多线程"+i);
        }
    }
}
