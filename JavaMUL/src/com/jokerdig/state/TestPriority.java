package com.jokerdig.state;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 10:58
 **/
//测试线程优先级
public class TestPriority{
}
class MyPriority implements  Runnable{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);

        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}