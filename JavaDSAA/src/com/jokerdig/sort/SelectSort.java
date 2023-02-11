package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/13 - 10:23
 **/
// 选择排序
public class SelectSort {
    public static void main(String[] args) {
        // 原始数组 [19,34,100,10,80]
        int[] arr = {19,34,100,10,80};
        selectSort(arr);
    }
    // 选择排序
    public static void selectSort(int[] arr){
        System.out.println("原始数组");
        System.out.println(Arrays.toString(arr));

        // 完整选择排序 时间复杂度O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i; // 假定初始值下标
            int min = arr[i]; // 假定初始值
            for(int j = i+1; j<arr.length;j++){
                if(min>arr[j]){
                    // 说明当前的值比我们假定的值大
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }
            // 将最小值放在arr[i]，交换位置
            // 如果minIndex没有变化过，那我们也就不需要交换
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮交换后");
            System.out.println(Arrays.toString(arr));
        }
        // 使用逐步推导的方式，来理解选择排序
        /*
        // 第一轮比较交换后
        int minIndex = 0; // 假定初始值下标
        int min = arr[0]; // 假定初始值
        for(int j = 0+1; j<arr.length;j++){
            if(min>arr[j]){
                // 说明当前的值比我们假定的值大
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }
        // 将最小值放在arr[0]，交换位置
        // 如果minIndex没有变化过，那我们也就不需要交换
        if(minIndex!=0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一轮交换后");
        System.out.println(Arrays.toString(arr));

        // 第二轮比较交换后
        minIndex = 1; // 假定初始值下标
        min = arr[1]; // 假定初始值
        for(int j = 1+1; j<arr.length;j++){
            if(min>arr[j]){
                // 说明当前的值比我们假定的值大
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }
        // 将最小值放在arr[1]，交换位置
        // 如果minIndex没有变化过，那我们也就不需要交换
        if(minIndex!=1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮交换后");
        System.out.println(Arrays.toString(arr));

        // 第三轮比较交换后
        minIndex = 2; // 假定初始值下标
        min = arr[2]; // 假定初始值
        for(int j = 2+1; j<arr.length;j++){
            if(min>arr[j]){
                // 说明当前的值比我们假定的值大
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }
        // 将最小值放在arr[2]，交换位置
        // 如果minIndex没有变化过，那我们也就不需要交换
        if(minIndex!=2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮交换后");
        System.out.println(Arrays.toString(arr));

        // 第四轮比较交换后
        minIndex = 3; // 假定初始值下标
        min = arr[3]; // 假定初始值
        for(int j = 3+1; j<arr.length;j++){
            if(min>arr[j]){
                // 说明当前的值比我们假定的值大
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }
        // 将最小值放在arr[3]，交换位置
        // 如果minIndex没有变化过，那我们也就不需要交换
        if(minIndex!=3){
            arr[minIndex] = arr[3];
            arr[3] = min;
        }
        System.out.println("第四轮交换后");
        System.out.println(Arrays.toString(arr));
         */
    }

}
