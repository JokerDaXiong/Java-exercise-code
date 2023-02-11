package com.jokerdig.queue;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2022/9/8 - 14:06
 **/
// 数组模拟环形队列
public class Demo02 {
    public static void main(String[] args) {
        // 测试队列
        // 创建一个环形队列
        // 当前环形队列最大有效数据为(3-1=2),因为我们保留了一个空间
        ArrayQueue1 arrayQueue = new ArrayQueue1(3);
        char key; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        // 输出菜单
        while(flag){
            System.out.println("=============环形队列验证==============");
            System.out.println("==========a: 添加队列============");
            System.out.println("==========g: 获取队列============");
            System.out.println("==========s: 查看队列============");
            System.out.println("==========h: 查看队列头的数据============");
            System.out.println("==========e: 退出程序============");
            System.out.print("请输入对应的字符：");
            key=scanner.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.print("请输入一个数字：");
                    int val = scanner.nextInt();
                    arrayQueue.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的头数据：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出");

    }
}
// 使用数组模拟环形队列，编写一个类
class ArrayQueue1{
    private int maxSize; // 数组最大容量
    private int front; // 队列头 默认为0
    private int rear; // 队列尾 默认为0
    private int arr[]; // 数组来模拟队列

    // 创建队列构造器,初始化数据
    public ArrayQueue1(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    // 判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    // 判断队列为空
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数据到队列
    public void addQueue(int num){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        arr[rear] =num;
        rear = (rear+1) % maxSize; // 将rear后移
    }
    // 获取(取出)队列数据
    public int getQueue(){
        if(isEmpty()){
            // 抛出异常,进程停止
            throw new RuntimeException("队列为空");
        }
        // front是指向队列的第一个元素
        /*  1. 先把front保存到临时变量
            2. 把front后移
            3. 把临时保存的变量返回
         */
        int val = arr[front];
        front = (front+1)%maxSize;
        return val;
    }
    // 显示队列所有数据
    public void showQueue(){
        // 判断是否空
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 从front开始遍历，到(front+当前队列有效值)结束
        for (int i=front; i<front+size();i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    // 求出当前队列的有效值的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }


    // 显示队列的头数据，不是取出数据
    public int headQueue(){
        // 判断是否空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}