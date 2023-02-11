package com.jokerdig.easyExcel;

/**
 * @author Joker大雄
 * @data 2022/9/5 - 14:32
 **/
public class test {
    public static void main(String[] args) {
        int i =1;
        int j =i++;
        if((i==(++j))&&((i++)==j)){
            i+=j;
        }
        System.out.println(i);
    }
}
