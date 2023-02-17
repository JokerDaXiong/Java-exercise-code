package com.jokerdig.common;

import lombok.Data;

/**
 * @author Joker大雄
 * @data 2023/1/4 - 16:08
 **/
@Data
public class Result {
    private int code; // 编码 200成功 / 400失败
    private String msg; //成功/失败信息
    private Long total; // 总条数
    private Object data; // 数据

    // 基础返回方法
    private static Result result(int code,String msg,Long total,Object data){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }
    // 失败方法
    public static Result fail(){
        return result(400,"失败",0L,null);
    }
    // 成功方法
    // 无参数
    public static Result suc(){
        return result(200,"成功",0L,null);
    }
    // data
    public static Result suc(Object data){
        return result(200,"成功",0L,data);
    }
    // data,total
    public static Result suc(Object data,Long total){
        return result(200,"成功",total,data);
    }
}
