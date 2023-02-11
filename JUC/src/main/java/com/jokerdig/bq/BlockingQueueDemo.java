package com.jokerdig.bq;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Joker大雄
 * @data 2022/8/22 - 17:10
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // test1();
        // test2();
        // test3();
        test4();
    }
    // 抛出异常
    public static void test1(){
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        // 抛出异常 IllegalStateException: Queue full
        // System.out.println(arrayBlockingQueue.add("d"));

        // 查看队首的元素
        System.out.println(arrayBlockingQueue.element());

        System.out.println("==========================");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // 抛出异常 java.util.NoSuchElementException
        // System.out.println(arrayBlockingQueue.remove());
    }

    // 不抛出异常
    public static void test2(){
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        // false 返回布尔值 不抛出异常
        // System.out.println(arrayBlockingQueue.offer("d"));

        // 返回队首元素
        System.out.println(arrayBlockingQueue.peek());

        System.out.println("==============================");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 返回 null  不抛出异常
        // System.out.println(arrayBlockingQueue.poll());

    }

    // 阻塞等待
    public static void test3() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        // 队列没有位置 它会一直阻塞
        // arrayBlockingQueue.put("d");
        System.out.println("==============================");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // 队列没有位置 它会一直阻塞
        // System.out.println(arrayBlockingQueue.take());
    }
    // 超时等待
    public static void test4() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
        //  超时等待 设置时间,时间结束如果还在阻塞就直接退出
        arrayBlockingQueue.offer("d",3,TimeUnit.SECONDS);
        System.out.println("==============================");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 超时等待 设置时间,时间结束如果还在阻塞就直接退出
         System.out.println(arrayBlockingQueue.poll(3,TimeUnit.SECONDS));
    }
}
