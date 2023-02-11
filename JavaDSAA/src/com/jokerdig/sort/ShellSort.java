package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/15 - 10:31
 **/
public class ShellSort {
    public static void main(String[] args) {
        // 原始数据
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("初始数组为");
        System.out.println(Arrays.toString(arr));
        // shellSort(arr);
        shellSort1(arr);
    }


    // 使用逐步推导编写希尔排序，交换式
    public static void shellSort(int[] arr){
        int temp = 0; // 中间变量
        int x = 0; // 记录排序次数
        // 完整希尔排序
        for(int gap = arr.length/2; gap>0; gap/=2){
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共5组，每组2个元素)
                for (int j = i - gap; j >=0 ; j-=gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序"+(++x)+"轮后");
            System.out.println(Arrays.toString(arr));
        }

        /*
        // 希尔排序第1轮排序
        // 因为第1轮排序，是将10个数组分成了5组
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素(共5组，每组2个元素)
            for (int j = i-5; j >=0 ; j-=5) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后");
        System.out.println(Arrays.toString(arr));

        // 希尔排序第2轮排序
        // 因为第2轮排序，是将10个数组分成了5/2=2组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的元素(共5组，每组2个元素)
            for (int j = i - 2; j >=0 ; j-=2) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后");
        System.out.println(Arrays.toString(arr));

        // 希尔排序第3轮排序
        // 因为第3轮排序，是将10个数组分成了2/2=1组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素(共5组，每组2个元素)
            for (int j = i - 1; j >=0 ; j-=1) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后");
        System.out.println(Arrays.toString(arr));
         */
    }
    // 希尔排序 移位式优化交换式速度
    public static void shellSort1(int[] arr) {
        int temp = 0; // 中间变量
        int x = 0; // 记录排序次数
        // 完整希尔排序
        // 增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[i];
                if(arr[j]<arr[j-gap]){
                    while(j-gap >= 0 && temp<arr[j-gap]){
                        // 移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    // 当退出while循环后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
            System.out.println("希尔排序" + (++x) + "轮后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
