package com.jokerdig.stack;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2022/9/30 - 12:17
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        // 测试栈
        // 先创建ArrayStack对象
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean flag = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("=========栈功能测试==========");
            System.out.println("======show:表示显示栈=======");
            System.out.println("======exit:退出程序=======");
            System.out.println("======push:表示添加数据到栈=======");
            System.out.println("======pop:表示从栈取出数据=======");
            System.out.println("请输入要测试的功能");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.listStack();
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                case "push":
                    System.out.println("请输入要添加栈的值");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int val = arrayStack.pop();
                        System.out.printf("出栈的数据%d\n",val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请输入正确的内容");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
// 定义一个类ArrayStack，表示栈结构
class ArrayStack{
    private int maxSize; // 栈的大小
    private int[]stack; // 使用数组模拟栈，数据存放在该数组
    private int top = -1; // 栈顶，没有数据为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize]; // 初始化
    }

    // 栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈
    public void push(int value){
        // 先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop(){
        // 先判断栈是否空
        if(isEmpty()){
            // 抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈，遍历时要从栈顶开始
    public void listStack(){
        // 先判断栈是否为空
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}