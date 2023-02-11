package com.jokerdig.state;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 14:23
 **/
//测试Join方法
public class TestJoin implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);

        //主线程
        for (int i = 1; i < 200; i++) {
            if(i==100){
               //start放这里防止vip线程提前同普通线程一起启动
                thread.start();
                thread.join();//插队
            }
            System.out.println("普通线程"+i);
        }
    }
    //插队
    @Override
    public void run() {
        for (int i = 1; i < 500; i++) {
            System.out.println("线程vip来了"+i);
        }
    }
}
