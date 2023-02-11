package com.jokerdig.recursion;

/**
 * @author Joker大雄
 * @data 2022/10/7 - 10:59
 **/
public class RecursionTest {
    public static void main(String[] args) {
        // 通过代码简单理解递归调用

        test(4);
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
}
