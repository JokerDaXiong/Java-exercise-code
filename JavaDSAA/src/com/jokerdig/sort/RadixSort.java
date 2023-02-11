package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/19 - 11:15
 **/
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        radixSort(arr);
    }

    // 基数排序方法
    public static void radixSort(int[] arr){

        // 完整基数排序
        // 得到数组中最大数的位数
        int max = arr[0]; // 假设第一个数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i]; // 找到最大值
            }
        }
        // 得到最大数是几位数
        int maxLength = (max + "").length();
        // 定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        /*
            说明：
            1. 二维数组包含10个一位数组
            2. 为了防止放入数时数据溢出，则每个一维数组(桶)，大小定为arr.length
            3. 很明确，基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中，实际存放了多少个数据；
        // 我们定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0,n = 1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的对应位的数
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序，将桶中的数据放回原来的数组中
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，我们才放入到原数组中
                if(bucketElementCounts[k] !=0){
                    // 循环第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr中
                        arr[index] = bucket[k][l];
                        index++; // 下标后移
                    }
                }
                // 第i+1轮处理后需要将每个bucketElementCounts[k]=0
                bucketElementCounts[k]=0;
            }
            System.out.println("第"+(i+1)+"轮基数排序后数组");
            System.out.println(Arrays.toString(arr));
        }
        /*
        // 推导过程
        // 第一轮排序(针对每个数字个位)
        // 定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中，实际存放了多少个数据；
        // 我们定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的个位置数
            int digitOfElement = arr[j] % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序，将桶中的数据放回原来的数组中
        int index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入到原数组中
            if(bucketElementCounts[k] !=0){
                // 循环第k个桶
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr中
                    arr[index] = bucket[k][l];
                    index++; // 下标后移
                }
            }
            // 第一轮处理后需要将每个bucketElementCounts[k]=0
            bucketElementCounts[k]=0;
        }
        System.out.println("第一轮基数排序后数组");
        System.out.println(Arrays.toString(arr));

        // 第二轮排序(针对每个数字十位)
        bucket = new int[10][arr.length];
        // 为了记录每个桶中，实际存放了多少个数据；
        // 我们定义一个一维数组来记录各个桶每次放入的数据个数
        bucketElementCounts = new int[10];
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的十位置数
            int digitOfElement = arr[j] /10 % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序，将桶中的数据放回原来的数组中
        index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入到原数组中
            if(bucketElementCounts[k] !=0){
                // 循环第k个桶
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr中
                    arr[index] = bucket[k][l];
                    index++; // 下标后移
                }
            }
            // 第二轮处理后需要将每个bucketElementCounts[k]=0
            bucketElementCounts[k]=0;
        }
        System.out.println("第二轮基数排序后数组");
        System.out.println(Arrays.toString(arr));

        // 第三轮排序(针对每个数字百位)
        bucket = new int[10][arr.length];
        // 为了记录每个桶中，实际存放了多少个数据；
        // 我们定义一个一维数组来记录各个桶每次放入的数据个数
        bucketElementCounts = new int[10];
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的百位置数
            int digitOfElement = arr[j] /100 % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序，将桶中的数据放回原来的数组中
        index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入到原数组中
            if(bucketElementCounts[k] !=0){
                // 循环第k个桶
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr中
                    arr[index] = bucket[k][l];
                    index++; // 下标后移
                }
            }
        }
        System.out.println("第三轮基数排序后数组");
        System.out.println(Arrays.toString(arr));
        */
    }

}

