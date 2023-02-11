package com.jokerdig;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joker大雄
 * @data 2022/8/16 - 11:02
 **/
public class Test1 {
    public static void main(String[] args) {
//        int []target = {1,2,3,4};
//        int [] arr = {1,3,2,4};
//        for(int i=1; i<target.length;i++){
//            for(int j=0;j<target.length-i;j++){
//                if(target[j]>target[j+1]){
//                    int temp = target[j];
//                    target[j] = target[j+1];
//                    target[j+1] = temp;
//                }
//                if(arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        if(Arrays.equals(target,arr)){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
////        }
//        int arr[] = {1,2,3,4,5,6,7,8,9};
//        int x=-1;
//        int k=5;
//        // x为0或者负数，直接以k长度截取arr数组并返回
//        if(x<=0){
//            int sum[] = Arrays.copyOfRange(arr,0,k);
//            for (int i : sum) {
//                System.out.println(i);
//            }
//        }
//        List<Integer> list = new ArrayList<Integer>();
//        for (int num : arr) {
//            list.add(num);
//        }
//        // 计算出更接近x的数并重新排序
//        Collections.sort(list, (a, b) -> {
//            if (Math.abs(a - x) != Math.abs(b - x)) {
//                return Math.abs(a - x) - Math.abs(b - x);
//            } else {
//                return a - b;
//            }
//        });
//        // 比较的list
//        List<Integer> ans = list.subList(0, k);
//        // 进行排序
//        Collections.sort(ans);
//        for (Integer an : ans) {
//            System.out.println(an);
//        }
//        for(int i=0;i<arr.length;i+=2){
//            System.out.println(i+"i");
//        }
//        int nums[] = {2,5,1,3,4,7};
//        int n=3;
//        int k=0;
//        int arr[] = new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            if(k<nums.length||n<nums.length){
//                arr[k]=nums[i];
//                arr[k+1]=nums[n];
//            }
//            k+=2;
//            n++;
//        }
//        return arr;
    }

}
