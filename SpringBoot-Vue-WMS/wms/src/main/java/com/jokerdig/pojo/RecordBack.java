package com.jokerdig.pojo;

import lombok.Data;

/**
 * @author Joker大雄
 * @data 2023/1/17 - 11:51
 **/
@Data
public class RecordBack extends Record{
    private String uname; // 用户名
    private String aname; // 管理员名
    private String gname; // 物品名
    private String tname; // 物品类型名
    private String sname; // 仓库名
}
