package com.jokerdig.thread;

/**
 * @author Joker大雄
 * @data 2021/8/23 - 12:38
 **/
//测试生产者消费者问题，信号灯法，标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}

//生产者-->演员
class Player extends Thread{

    TV tv = new TV();

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("是首相正在热播");
            }else{
                this.tv.play("宫崎骏电影轮播");
            }
        }
    }
}
//消费者-->观众
class Watcher extends Thread{
    TV tv = new TV();

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//产品-->节目
class TV {
    //演员表演，观众等地啊

    //观众观看，演员等待
    String voice;//表演节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }
    //观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了："+voice);
        //通知演员表演
        this.notifyAll();
        this.flag=!this.flag;
    }

}