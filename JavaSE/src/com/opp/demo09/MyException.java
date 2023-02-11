package com.opp.demo09;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 15:36
 **/
//自定义异常
public class MyException extends Exception{

    //传递数字>10 抛出异常
    private int detail;

    public MyException(int a){
        this.detail = a;
    }
    //toString ： 异常打印

    @Override
    public String toString() {
        return "MyException：" + detail;
    }
}

