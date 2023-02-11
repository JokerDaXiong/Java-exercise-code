package com.jokerdig.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/10/21 - 13:03
 **/
// 二分查找要求数组必须是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,89,89,1000,1234};
        List<Integer> list = binarySearch1(arr,0,arr.length-1,89);
        if(list.isEmpty()){
            System.out.println("没有找到该值");
        }else{
            System.out.println("要找的值下标为:"+list);
        }
    }
    // 二分查找算法
    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，没找到就返回-1
     */
    public static int binarySearch(int[] arr,int left, int right,int findVal){
        // 如果left>right，说明数组查找完毕且没有找到该值
        if(left>right){
            return -1;
        }
        int mid = (left+right) /2; // 中间值下标
        int midVal = arr[mid]; // 中间值

        if(findVal>midVal){
            // 向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            // 向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            // 找到直接返回
            return mid;
        }
    }

    // 二分查找多个相同值
    // 定义一个List集合，存放满足条件的值的下标
    static List<Integer> list = new ArrayList<>();
    public static List<Integer> binarySearch1(int[] arr, int left, int right, int findVal){
        // 如果left>right，说明数组查找完毕且没有找到该值
        if(left>right){
            return list;
        }
        int mid = (left+right) /2; // 中间值下标
        int midVal = arr[mid]; // 中间值

        if(findVal>midVal){
            // 向右递归
            return binarySearch1(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            // 向左递归
            return binarySearch1(arr,left,mid-1,findVal);
        }else{
            // 向左扫描
            int temp = mid -1;
            while(true){
                if(temp<0 || arr[temp] != findVal){
                    break;
                }
                // 否则就将temp放入集合中
                list.add(temp);
                temp -= 1; // temp左移
            }
            // 如果中间值是要找到值，就放入
            list.add(mid);
            // 向右扫描
            temp = mid + 1;
            while(true){
                if(temp>arr.length-1 || arr[temp] != findVal){
                    break;
                }
                // 否则就将temp放入集合中
                list.add(temp);
                temp += 1; // temp右移
            }
        }
        return list;// 返回集合
    }
}
