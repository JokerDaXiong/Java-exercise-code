package com.jokerdig.state;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 11:07
 **/
//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false

        thread.start();//上帝守护线程
        new Thread(you).start();//you启动

    }
}

//god
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑着你");
        }
    }
}
//you
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("-========goodbye! world========--");//hello world
    }
}
