package com.jokerdig.array;

/**
 * @author Joker大雄
 * @data 2021/8/13 - 14:11
 **/
public class ArrayDemo04 {
    public static void main(String[] args) {
        int[]arrays = {1,2,3,4,5};
        //增强for循环
        for (int array : arrays) {
            System.out.println(array);
        }
        printArray(arrays);
        System.out.println("=============");
        int[] arrayR=reverse(arrays);
        printArray(arrayR);
    }
    //打印数组元素
    public static void printArray(int[]arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]+"");
        }
    }
    //反转数组
    public static int[] reverse(int[]arrays){
        int[]arrayR = new int[arrays.length];
        //一个for循环定义两个变量
        for (int i=0,j = arrayR.length-1; i <arrays.length ; i++,j--) {
           arrayR[j]=arrays[i];
        }
        return arrayR;
    }
}
