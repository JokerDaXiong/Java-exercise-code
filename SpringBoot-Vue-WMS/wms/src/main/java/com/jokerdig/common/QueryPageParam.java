package com.jokerdig.common;

import lombok.Data;

import java.util.HashMap;

/**
 *  分页封装类
 * @author 王省雄
 * @data 2023/1/4 - 14:14
 **/
@Data
public class QueryPageParam {
    // 定义分页默认值
    private static int PAGE_SIZE = 10;
    private static int PAGE_NUM = 1;

    // 定义接收分页参数
    private int pageSize = PAGE_SIZE;
    private int pageNum = PAGE_NUM;
    // 这里存放数据
    private HashMap param = new HashMap();
}
