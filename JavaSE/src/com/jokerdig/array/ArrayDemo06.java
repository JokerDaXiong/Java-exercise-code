package com.jokerdig.array;


//import java.util.Arrays;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2021/8/13 - 16:03
 **/
public class ArrayDemo06 {
    public static void main(String[] args) {
       int []a={12312,451241,3,422,3,66,12312,534534,98};
       //打印数组元素Arrays.toString()
        System.out.println(Arrays.toString(a));
        System.out.println("=============================================");
        printArray(a);//调用方法

        //数组排序  Arrays.sort() 升序
        System.out.println("=============================================");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //数组填充  Arrays.fill
        System.out.println("=============================================");
        Arrays.fill(a,0);
        Arrays.fill(a,2,5,66);//2~5之间被66填充
        System.out.println(Arrays.toString(a));

    }
    //自定义Arrays.toString()打印数组方法
    //不要重复造轮子
    public static void printArray(int[]arr){

        for (int i=0;i< arr.length;i++) {
             if(i==arr.length-1){
                 System.out.print(arr[i]+"]\n");
             }else if(i==0){
                 System.out.print("["+arr[i]+", ");
             }else{
                 System.out.print(arr[i]+", ");
             }
        }
    }

}
