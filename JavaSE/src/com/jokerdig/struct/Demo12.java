package com.jokerdig.struct;

/**
 * @author Joker大雄
 * @data 2021/8/11 - 20:03
 **/
public class Demo12 {
    public static void main(String[] args) {
        //break
        int i=0;
        while(i<100){
            i++;
            System.out.println(i);
            if(i==30){
                break;//跳出循环，程序未终止
            }
        }

        //continue
        while(i<100){
            i++;
            if(i%10==0){
                System.out.println();
                continue;//跳到循环开始
            }
            System.out.println(i);
        }

        //打印101~150之间的所有 质数(大于1的自然数中，除了1和它本身外不在有其他因素的自然数)
        // 标签写法
        int count = 0;
        outer:for (int i1 = 101; i1 < 150; i1++) {
            for (int i2 = 2; i2 < i1/2; i2++) {
                if(i1 % i2 ==0){
                   continue outer;
                }
            }
            System.out.print(i1+" ");
        }

    }
}
