package com.jokerdig.util;


import java.util.UUID;

/**
 * @author Joker大雄
 * @data 2022/5/5 - 12:18
 **/
public class IDUtils {
    // 在企业开发中中，id一般都是随机生成
    public static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
