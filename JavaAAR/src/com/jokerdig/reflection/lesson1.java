package com.jokerdig.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2021/9/25 - 16:45
 **/
public class lesson1 {
        public static void main(String[] args) {
            // 构造从start到end的序列：
            final int start = 10;
            final int end = 20;
            List<Integer> list = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                list.add(i);
            }
            // 随机删除List中的一个元素:
            int removed = list.remove((int) (Math.random() * list.size()));
            int found = findMissingNumber(start, end, list);
            System.out.println(list.toString());
            System.out.println("missing number: " + found);
            System.out.println(removed == found ? "测试成功" : "测试失败");
        }
    static int findMissingNumber(int start, int end, List<Integer> list) {
        List<Integer> list2= new ArrayList<>();
        int i=0;
        int back=0;
        for (int j = start; j <= end; j++) {
            list2.add(j);
        }

        for (i = 0; i < list.size(); i++) {

            if(list.get(i)!=list2.get(i)){
                back=list2.get(i);
                break;
            }
        }

        return back;
    }
}
