package com.jokerdig.demo03;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 17:14
 **/
// 房东
public class Host implements Rent {

    // 实现租客的方法
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
