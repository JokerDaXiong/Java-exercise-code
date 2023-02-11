package com.jokerdig.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/12 - 12:21
 **/
// 冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        int temp = 0; // 临时变量

        // 为了容易理解，我们把冒泡排序的过程展示出来
        // 第一趟排序，就是最大的数拍到最后
//        for(int j = 0;j<arr.length-1;j++){
//            // 如果前面的数比后面的数大，就交换
//            if(arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第一趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第二趟排序，就是将第二大的数排在倒数第二位
//        for(int j = 0;j<arr.length-1-1;j++){
//            // 如果前面的数比后面的数大，就交换
//            if(arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第三趟排序，就是将第三大的数排在倒数第三位
//        for(int j = 0;j<arr.length-1-2;j++){
//            // 如果前面的数比后面的数大，就交换
//            if(arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第三趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第四趟排序，就是将第四大的数排在倒数第四位
//        for(int j = 0;j<arr.length-1-3;j++){
//            // 如果前面的数比后面的数大，就交换
//            if(arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第四趟排序后的数组");
//        System.out.println(Arrays.toString(arr));

        // 完整冒泡排序过程
        // 冒泡排序时间复杂度O(n^2)
//        for (int i = 0; i < arr.length-1; i++) {
//            for(int j = 0;j<arr.length-1-i;j++){
//                // 如果前面的数比后i面的数大，就交换
//                if(arr[j]>arr[j+1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
//        }

        boolean flag = false; // 标识符
        // 冒泡排序优化
        // 冒泡排序时间复杂度O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            for(int j = 0;j<arr.length-1-i;j++){
                // 如果前面的数比后i面的数大，就交换
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if(!flag){
                // 说明在一趟排序中，没发生过一次交换
                break;
            }else{
                flag = false; // 重置flag，进行下一次判断记录
            }
        }
    }
    // 将冒泡排序封装为一个方法
    public int[] BubbleSort(int [] arr){
        int temp = 0; // 临时变量
        boolean flag = false; // 标识符
        // 冒泡排序优化
        // 冒泡排序时间复杂度O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            for(int j = 0;j<arr.length-1-i;j++){
                // 如果前面的数比后i面的数大，就交换
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                // 说明在一趟排序中，没发生过一次交换
                break;
            }else{
                flag = false; // 重置flag，进行下一次判断记录
            }
        }
        return arr;
    }
}
