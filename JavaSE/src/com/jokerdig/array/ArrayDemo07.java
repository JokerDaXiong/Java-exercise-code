package com.jokerdig.array;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2021/8/13 - 17:45
 **/
public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] a={3,42,6,56,2,5,22,33,4,32,9};

        int []sort=sort(a);
        System.out.println(Arrays.toString(sort));

    }
        //冒泡排序
        //1.比较数组中两个相领的元素，第二个比第一个大，就交换位置
        //2.每次比较都会产生一个最大或者最小的数字
        //3.下一轮则可以少一次排序，依次循环

    public static int[] sort(int[]array){
        //临时变量
        int temp = 0;
        boolean flag = false;
        //外层循环
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环，如果第一个比第二个大，则交换位置
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j+1]<array[j]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=true;
                }
            }
            //简单优化，减少不必要的循环
            if(flag==false){
                break;
            }
        }
        return array;
    }
}
