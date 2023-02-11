package com.opp.demo01;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 19:32
 **/
public class Students {
    //private 私有
    /*
     封装的优势：
     1. 提高程序的安全性，保护数据
     2. 隐藏代码的实现细节
     3. 同意接口
     4. 系统可维护性增加
     */

    private String name; //名字
    private int id;    //学号
    private char set;  //性别

    //get/set方法
    //get获取这个数据
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
