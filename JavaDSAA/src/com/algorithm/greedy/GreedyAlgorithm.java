package com.algorithm.greedy;

import java.util.*;

/**
 * @author Joker大雄
 * @data 2022/11/28 - 9:48
 **/
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台,放到map中
        Map<String, HashSet> broadcasts = new HashMap<>();
        // 将电台放入
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        // 放入HashMap
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        // 创建allAreas，存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        // 创建存放选择的电台集合的ArrayList
        List<String> selects = new ArrayList<>();
        // 定义临时集合，在遍历过程中存放电台覆盖地区和当前没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();
        // 记录最大的可再覆盖的size
        HashSet<String> tempSet2 = new HashSet<>();

        // 定义maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖地区对应的电台的key
        // 如果maxKey不为null，则会加入到selects
        String maxKey = null;
        while(allAreas.size()!=0){// 如果allAreas不为0，则表示还没有覆盖到所有的地区
            maxKey = null; // 每次执行需要将maxKey置空
            // 遍历 broadcasts，取出对应的key
            for (String key : broadcasts.keySet()){
                tempSet.clear(); // 每进行一次for循环，需要清空tempSet
                // 当前这个key能够覆盖的地区
                HashSet areas = broadcasts.get(key);
                tempSet.addAll(areas); // 地区添加到临时集合
                // 求出tempSet和allAreas集合的交集，并将交集赋给tempSet
                tempSet.retainAll(allAreas);
                // 如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合未覆盖的地区还要多
                // 就需要重置maxKey
                if(tempSet.size() > 0 &&
                        (maxKey == null|| tempSet.size()>tempSet2.size())){
                    maxKey = key;
                    tempSet2 = tempSet; // 如果tempSet大于tempSet2，就把它赋给tempSet2
                }
            }
            // maxKey != null，就将maxKey加入selects
            if(maxKey != null){
                selects.add(maxKey);
                // 将maxKey指向的广播电台覆盖的地区从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("所选择的结果为："+selects);
    }
}
