package com.jokerdig.thread;

/**
 * @author Joker大雄
 * @data 2021/8/23 - 12:11
 **/
//测试：生产者消费者模型->利用缓冲区解决：管程法
public class TestPC {
    public static void main(String[] args) {
        Syncontainer con = new Syncontainer();

        new Productor(con).start();
        new Consumer(con).start();
    }

}
//生产者
class Productor extends Thread{
    Syncontainer con;

    public Productor(Syncontainer con) {
        this.con = con;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            con.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    Syncontainer con;

    public Consumer(Syncontainer con) {
        this.con = con;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了->"+con.pop().id+"只鸡");
        }
    }
}
//产品
class Chicken{
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class Syncontainer{
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;
    //生产者放入产品
    public synchronized  void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，我们就放入产品
        chickens[count] = chicken;
        count++;
        //可以通知消费者消费
        this.notifyAll();
    }
    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(count==0){
            //等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费
        count--;
        Chicken chicken = chickens[count];
        //通知生产者生产
        this.notifyAll();
        return chicken;
    }
}