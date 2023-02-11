package com.jokerdig.thread;

/**
 * @author Joker大雄
 * @data 2021/8/23 - 10:13
 **/
//死锁：多个线程互相抱着对方的资源，然后形成死锁
public class DeadLock {
    public static void main(String[] args) {
        Makeup mk = new Makeup(0,"灰姑娘");
        Makeup mk2 = new Makeup(1,"白雪公主");

        mk.start();
        mk2.start();


    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
//化妆
class Makeup extends Thread{
    //static来保证需要的资源只有一份
    static Lipstick lipstic = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //互相持有对方的锁
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstic){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
            }

            synchronized (lipstic){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}