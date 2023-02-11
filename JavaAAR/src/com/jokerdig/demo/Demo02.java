package com.jokerdig.demo;

/**
 * @author Joker大雄
 * @data 2021/9/6 - 21:15
 **/
@SuppressWarnings("all")//取消警告提示
public class Demo02 extends Object{

    //@Override  重写的注释
    @Override
    public String toString() {
        return super.toString();
    }
    //过时的，已被淘汰的
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    public static void main(String[] args) {
        test();//已过时，但也能用
    }



}
