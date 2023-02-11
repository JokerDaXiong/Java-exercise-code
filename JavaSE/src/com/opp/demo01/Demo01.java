package com.opp.demo01;

import java.io.IOException;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 17:54
 **/
public class Demo01 {
    //main方法
    public static void main(String[] args) {

    }
    /*
      修饰符 返回值类型 方法名(...)
     */
    public String sayHello(){
        return "Hello World";
    }

    public int max(int a,int b){
        return a>b?a:b; //三元运算符
    }
    //抛出异常
    public void readFile(String file) throws IOException {

    }
}
