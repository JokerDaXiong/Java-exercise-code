package com.jokerdig.tree;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/11/4 - 11:20
 **/
// 堆排序
public class HeapSort {
    public static void main(String[] args) {
        // 要求对数组进行升序排序
        int arr[] = {4,6,8,5,9};
        System.out.println("原始数组："+ Arrays.toString(arr));
        headSort(arr);
    }
    // 编写堆排序方法
    public static void headSort(int arr[]){
        int temp = 0; // 临时变量
        System.out.println("======堆排序======");
        // 分步骤完成
        /*
        adjustHeap(arr,1,arr.length);
        System.out.println("第1次调整："+ Arrays.toString(arr));

        // 第二次调整
        adjustHeap(arr,0,arr.length);
        System.out.println("第2次调整："+ Arrays.toString(arr));
         */
        // 完整堆排序
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i, arr.length);
        }
        for (int j = arr.length-1; j > 0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j); // 总是从第一个值开始调整
        }
        System.out.println("堆排序结果："+ Arrays.toString(arr));
    }
    // 将一个数组(对应二叉树)调整成一个大顶堆
    /**
     *举例：
     * 当 i=1==>{4,6,8,5,9}=>{4,9,8,5,6}
     * 当 i=0==>{4,9,8,5,6}=>{9,6,8,5,4}
     *
     * @param arr 待排序数组
     * @param i 表示非叶子节点在数组中的索引
     * @param len 数组长度，即对多少个元素进行调整
     */
    public static void adjustHeap(int arr[],int i,int len){

        int temp = arr[i]; // 先取出当前元素的值，保存在临时变量
        // 开始调整，左子节点
        for(int k = i*2+1; k<len; k=k*2+1){
            if(k+1<len && arr[k]<arr[k+1]){ // 说明左子节点的值小于右子节点的值
                k++; // k指向右子节点
            }
            if(arr[k]>temp){ // 如果子节点大于父节点
                arr[i] = arr[k]; // 把较大的值赋给当前节点
                i = k; // i指向k，继续循环比较
            }else{
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶部（局部）
        arr[i] = temp; // 将temp值放到调整后的位置
    }
}
