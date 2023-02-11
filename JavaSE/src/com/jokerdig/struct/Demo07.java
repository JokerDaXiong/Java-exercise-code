package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 18:07
 **/
public class Demo07 {
    public static void main(String[] args) {

        int a =0;
        while(a<0){
            System.out.println(a);
            a++;
        }
        System.out.println("=====================");
        do{
            System.out.println(a);
            a++;
        }while(a<0);
    }
}
