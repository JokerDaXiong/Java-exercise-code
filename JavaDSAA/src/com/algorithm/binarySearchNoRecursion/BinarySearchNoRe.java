package com.algorithm.binarySearchNoRecursion;

/**
 * @author Joker大雄
 * @data 2022/11/24 - 9:35
 **/
public class BinarySearchNoRe {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        // 测试二分查找
        int index = binarySearch(arr, 10);
        if(index!=-1){
            System.out.println("要查找的数的下标为："+index);
        }else{
            System.out.println("要查找的数不在该数组内");
        }
    }
    // 二分查找算法的非递归实现
    /**
     *
     * @param arr 待查找的数组，这里arr数组升序排列
     * @param target 需要查找的数
     * @return 返回对应的下标，-1表示没找到
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){// 说明继续查找
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]>target){
                right = mid-1; //需要向左查找
            }else{
                left = mid +1; //需要向右边查找
            }
        }
        return -1; // 没找到
    }
}
