package com.jokerdig.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/10/20 - 10:18
 **/
// 线性查找
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,43,89,11,3,12,11};// 定义一个无序数组
        List list = seqSearch(arr, 11);
        System.out.println("下标为："+list);
    }
    // 查找所有符合条件的值的下标
    public static List<Integer> seqSearch(int[]arr, int value){
        // 定义集合，存放下标
        List<Integer> list = new ArrayList<>();
        // 线性查找就是逐一比对，发现有相同值，就将下标放入数组
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                list.add(i);
            }
        }
        return list;
    }
}
