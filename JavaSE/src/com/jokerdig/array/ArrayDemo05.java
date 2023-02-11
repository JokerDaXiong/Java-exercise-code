package com.jokerdig.array;

/**
 * @author Joker大雄
 * @data 2021/8/13 - 15:44
 **/
public class ArrayDemo05 {
    public static void main(String[] args) {
        //二维数组
        int[][] array = {{1,2},{3,4},{5,6}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
