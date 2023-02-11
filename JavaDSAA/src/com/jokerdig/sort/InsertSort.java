package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/14 - 10:28
 **/
// 插入排序
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {17,3,25,9};
        insertSort(arr);
    }
    // 插入排序
    public static void insertSort(int[]arr){
        System.out.println("初始数据为");
        System.out.println(Arrays.toString(arr));
        // 完整插入排序
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            // 定义待插入数的索引，arr[1]前面的下标
            insertIndex = i-1;
            // 给insertVal找到要插入的位置
            // 保证找到待插入位置时不越界，且保证没找到待插入位置要一直循环
            while(insertIndex>=0 && insertVal < arr[insertIndex]){
                // 将arr[insertIndex]后移
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到，insertIndex+1
            // 判断是否需要赋值，进行优化
            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }

            System.out.println("第"+i+"轮插入后");
            System.out.println(Arrays.toString(arr));
        }

        // 使用逐步推导，便于理解
        // 第一轮{17,3,25,9}->{3,17,25,9}
        // 定义待插入的数
        /*
        int insertVal = arr[1];
        // 定义待插入数的索引，arr[1]前面的下标
        int insertIndex = 1-1;
        // 给insertVal找到要插入的位置
        // 保证找到待插入位置时不越界，且保证没找到待插入位置要一直循环
        while(insertIndex>=0 && insertVal < arr[insertIndex]){
            // 将arr[insertIndex]后移
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1] = insertVal;

        System.out.println("第一轮插入后");
        System.out.println(Arrays.toString(arr));

        // 第二轮{3,17,25,9}->{3,17,25,9}
        // 定义待插入的数
        insertVal = arr[2];
        // 定义待插入数的索引，arr[2]前面的下标
        insertIndex = 2-1;
        // 给insertVal找到要插入的位置
        // 保证找到待插入位置时不越界，且保证没找到待插入位置要一直循环
        while(insertIndex>=0 && insertVal < arr[insertIndex]){
            // 将arr[insertIndex]后移
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1] = insertVal;

        System.out.println("第二轮插入后");
        System.out.println(Arrays.toString(arr));

        // 第三轮{3,17,25,9}->{3,17,25,9}
        // 定义待插入的数
        insertVal = arr[3];
        // 定义待插入数的索引，arr[3]前面的下标
        insertIndex = 3-1;
        // 给insertVal找到要插入的位置
        // 保证找到待插入位置时不越界，且保证没找到待插入位置要一直循环
        while(insertIndex>=0 && insertVal < arr[insertIndex]){
            // 将arr[insertIndex]后移
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1] = insertVal;

        System.out.println("第三轮插入后");
        System.out.println(Arrays.toString(arr));
         */
    }
}
