package com.opp.demo07;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 14:53
 **/
public class Test {
    public static void main(String[] args) {
       // System.out.println(11/0);

    }
    //反复调用异常
    public void a(){
        b();
    }
    public void b(){
        a();
    }
}
