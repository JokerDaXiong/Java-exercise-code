package com.jokerdig.search;

/**
 * @author Joker大雄
 * @data 2022/10/22 - 9:43
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        // 生成1-100有序数组
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int back = insertValueSearch(arr,0,arr.length-1,10);
        if(back==-1){
            System.out.println("没有找到该值");
        }else{
            System.out.println("该值的下标为:"+back);
        }
    }
    // 编写插值查找算法(要求数组有序)
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，没找到返回-1
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if(left>right || findVal < arr[0] || findVal > arr[arr.length-1]){
            // 查找结束且没找到
            return -1;
        }
        // 求出中间值
        int midIndex = left +(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[midIndex];

        if(findVal>midValue){
            // 向右递归
            return insertValueSearch(arr,midValue+1,right,findVal);
        }else if(findVal<midValue){
            // 向左递归
            return insertValueSearch(arr,left,midValue-1,findVal);
        }else{
            // 找到值
            return midIndex;
        }
    }
}
