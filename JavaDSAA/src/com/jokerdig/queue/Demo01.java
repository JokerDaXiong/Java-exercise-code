package com.jokerdig.queue;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2022/9/8 - 12:27
 **/
// 数组模拟队列
public class Demo01 {
    public static void main(String[] args) {
        // 测试队列
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        // 输出菜单
        while(flag){
            System.out.println("=============队列验证==============");
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
// 使用数组模拟队列，编写一个类
class ArrayQueue{
    private int maxSize; // 数组最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int arr[]; // 数组来模拟队列

    // 创建队列构造器,初始化数据
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头，实际上指向队列头的前一个位置
        rear = -1; // 指向队列尾部,实际指向队列尾部数据(包含尾部)
    }
    // 判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
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
        rear++; // rear向后移
        arr[rear] =num;
    }
    // 获取(取出)队列数据
    public int getQueue(){
        if(isEmpty()){
            // 抛出异常,进程停止
            throw new RuntimeException("队列为空");
        }
        front++;// front 向后移
        return arr[front];
    }
    // 显示队列所有数据
    public void showQueue(){
        // 判断是否空
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 遍历
        for (int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    // 显示队列的头数据，不是取出数据
    public int headQueue(){
        // 判断是否空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
