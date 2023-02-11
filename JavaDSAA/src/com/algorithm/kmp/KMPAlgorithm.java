package com.algorithm.kmp;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/11/26 - 13:22
 **/
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2); // 获取部分匹配表
        System.out.println(Arrays.toString(next)); // 部分匹配表打印
        // 测试KMP算法
        int index = kmpSearch(str1, str2, next);
        System.out.println("index="+index);
    }
    // kmp搜索算法
    /**
     *
     * @param str1 要查找的字符串
     * @param str2 匹配的的子串
     * @param next 子串对应的部分匹配值表
     * @return 返回找到的下标，没找到返回-1
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        // 遍历
        for (int i = 0,j = 0; i < str1.length(); i++) {
            // 需要考虑str1.charAt(i) != str2.charAt(j)
            // KMP算法核心点
            while(j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()) { // 找到
                return i - j + 1;
            }
        }
         return -1;
    }

    // 获取字符串(子串)的部分匹配值表
    public static int[] kmpNext(String dest){
        // 创建next数组，保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; // 如果字符串长度为1，部分匹配值就是0
        for (int i = 1,j = 0; i < dest.length(); i++) {

            // 当dest.charAt(i) != dest.charAt(j)
            // 我们需要从next[j-1]获取新的j
            // KMP算法的一个核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            // 当该条件满足，部分匹配值+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
