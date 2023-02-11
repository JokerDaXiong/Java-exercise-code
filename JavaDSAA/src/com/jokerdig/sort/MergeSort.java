package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/18 - 9:39
 **/
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
        System.out.println("初始数组");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后数组");
        System.out.println(Arrays.toString(arr));
    }

    // 归并(分解+合并)
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2; //中间索引
            // 向左递归进行分解
            mergeSort(arr,left,mid,temp);
            // 向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            // 合并
            merge(arr,left,mid,right,temp);
        }
    }
    // 合并
    /**
     *
     * @param arr  原始数组
     * @param left 左边有序序列初始索引
     * @param mid 中间索引
     * @param right 最后的索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[]temp){
        int i = left; // 初始化i，左边有序序列初始索引
        int j = mid+1; // 初始化j，右边有序序列初始索引
        int t = 0; // 指向temp数组的当前索引
        // 先把左右两边的数据按照规则填充到temp数组，直到左右两边有序序列其中一边处理完毕为止
        while(i<=mid && j<=right){
            // 继续
            // 左边序列当前元素小于或者等于右边序列当前元素
            if(arr[i]<=arr[j]){
                temp[t] = arr[i]; // 把左边序列当前值放到temp中
                t += 1; // temp当前索引后移
                i += 1; // 左边序列索引后移
            }else{
                temp[t] = arr[j]; // 把右边序列当前值放到temp中
                t += 1; // temp当前索引后移
                j += 1; // 右边序列索引后移
            }
        }
        // 把有剩余数据的一边依次填充到temp
        while(i<=mid){ // 左边有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j<=right){ // 右边有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // 将temp数组重新拷贝到arr
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t]; // 从temp拷贝到arr
            t += 1; // temp索引后移
            tempLeft +=1; // arr索引后移
        }
    }
}
