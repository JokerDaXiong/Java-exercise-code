package com.jokerdig.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Joker大雄
 * @data 2022/8/19 - 12:43
 **/
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable(...)).start();
        // new Thread(new FutureTask<V>()).start();
        // new Thread(new FutureTask<V>(Callable)).start();
        myThread myThread = new myThread();
        // 适配类
        FutureTask futureTask = new FutureTask(myThread);
        // 启动 callable
        new Thread(futureTask,"A").start();
        // 有AB两个线程，结果会被缓存，效率高
        new Thread(futureTask,"B").start();
        // callable 返回值  get()方法可能会产生阻塞，把它放到最后或者使用异步通信
        Integer out = (Integer) futureTask.get();
        System.out.println(out);
    }
}
// 泛型的值和返回值的类型相同
class myThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        // 耗时操作
        return 1024;
    }
}

