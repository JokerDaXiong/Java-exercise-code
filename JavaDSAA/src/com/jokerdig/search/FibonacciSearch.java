package com.jokerdig.search;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/10/24 - 9:16
 **/
// 斐波那契查找
public class FibonacciSearch {
    public static int maxSize = 20;// 最大值
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int back = fibSearch(arr, 10);
        if(back==-1){
            System.out.println("没找到该数值");
        }else{
            System.out.println("下标为："+back);
        }
    }
    // 斐波那契查找法，需要使用到斐波那契数列
    // 因此我们需要先获构建一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    // 编写斐波那契查找算法，这里没使用递归来写
    /**
     *
     * @param a 数组
     * @param key 需要查找的数
     * @return 下标，没找到返回-1
     */
    public static int fibSearch(int[] a,int key) {
        // 定义初始下标
        int low = 0;
        int high = a.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放mid
        int f[] = fib(); // 获取斐波那契数列
        // 获取斐波那契分隔值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k]的值，可能大于a的长度
        // 因此我们需要使用Arrays类，构造新的数组并指向temp[]
        int[] temp = Arrays.copyOf(a, f[k]); // 不足的部分会使用0填充
        // 需要使用a数组的最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        // 使用while来循环处理，找到我们的数key
        while (low <= high) {
            // 只要这个条件满足，我们就可以找中间值
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                // 说明我们应该向数组左边查找
                high = mid - 1;
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为左边有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                // 即在f[k-1]前面继续查找，k--
                // 下次循环mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                // 继续向数组的右边查找
                low = mid + 1;
                // 1.全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 3. 因为后面有f[k-2]，所以可以继续拆分f[k-1] = f[k-3] + f[k-4]
                // 在f[k-2]的前面进行查找k-=2
                // 下次循环mid = f[k-1-2]-1
                k -= 2;
            } else {
                // 找到了，并判断返回哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
