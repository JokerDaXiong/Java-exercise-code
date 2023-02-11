package com.jokerdig.state;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 10:45
 **/
//测试线程状态
public class TestState1 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//new

        //观察启动后
        thread.start();
        state=thread.getState();
        System.out.println(state);//Run
        //只要不中止就一直输出状态
        while(state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state= thread.getState();
            System.out.println(state);
        }
        //死亡后的线程不能在启动
    }
}
