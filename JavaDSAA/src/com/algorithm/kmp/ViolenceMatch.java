package com.algorithm.kmp;

/**
 * @author Joker大雄
 * @data 2022/11/26 - 10:43
 **/
public class ViolenceMatch {
    public static void main(String[] args) {
        // 测试暴力匹配
        String str1 = "adc bcd abcdcdabd";
        String str2="abc";
        int index = violenceMatch(str1, str2);
        System.out.println("index="+index);// 包含空格
    }

    // 暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0, j = 0; // i指向s1，j指向s2
        while (i < s1Len && j < s2Len) {// 保证匹配不越界
            if (s1[i] == s2[j]) {// 匹配成功
                i++;
                j++;
            } else {// 没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        // 判断匹配是否成功
        if(j == s2Len){
            return i-j;
        }else{
            return -1;
        }
    }
}
