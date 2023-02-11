package com.jokerdig.sort;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/17 - 12:09
 **/
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {-9,78,0,23,-567,70};
        System.out.println("初始数组");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("快速排序后数组");
        System.out.println(Arrays.toString(arr));
    }
    // 快速排序
    public static void quickSort(int[]arr,int left,int right){
        int lt = left;  // 左下标
        int rt = right; // 右下标
        int pivot = arr[(left+right)/2]; // pivot 中轴值
        int temp = 0; // 临时变量，用来交换
        // while循环的目的是让比pivot值小的放到左边，比pivot大的放到右边
        while(lt < rt){
            // 在pivot左边找到一个大于等于pivot的值
            while(arr[lt] < pivot){
                lt +=1;
            }
            // 在pivot右边找到一个小于等于pivot的值
            while(arr[rt] > pivot){
                rt -=1;
            }
            // 左边>=右边，说明左边的值都小于右边了
            if(lt >= rt){
                break;
            }
            // 交换
            temp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = temp;

            // 如果交换完后，发现arr[lt] == pivot，就让右边前移
            if(arr[lt] == pivot){
                rt-=1;// 前移
            }
            // 如果交换完后，发现arr[rt] == pivot，就让左边后移
            if(arr[rt] == pivot){
                lt+=1;// 后移
            }
        }
        // 如果lt == rt，必须lt++，r--,否则会栈溢出
        if(lt==rt){
            lt+=1;
            rt-=1;
        }
        // 向左递归
        if(left < rt){
            quickSort(arr,left,rt);
        }
        // 向右递归
        if(right > lt){
            quickSort(arr,lt,right);
        }
    }
}
