package com.jokerdig.demo1;

/**
 * @author Joker大雄
 * @data 2021/8/20 - 19:04
 **/
//创建线程方式2：实现runnable接口，重写run方法，执行线程丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable{


   //重写run方法
    @Override
    public void run() {
        //run方法
        for (int i = 0; i < 20; i++) {
            System.out.println("在看代码"+i);
        }
    }

    public static void main(String[] args) {
        //main方法
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，来开启start
        Thread thread = new Thread(testThread3);
        //调用start()方法i
        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("学习多线程"+i);
        }
    }
}
