package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 18:56
 **/
public class Demo09 {
    public static void main(String[] args) {
        //练习2：用while或for循环输出1~1000之间能被5整除的数，并且每行输出3个
        for (int i = 0; i < 1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t");
            }
            if(i%(5*3)==0){
                System.out.println();//换行
            }

        }
    }
}
