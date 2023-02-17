package com.jokerdig.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jokerdig.common.QueryPageParam;
import com.jokerdig.common.Result;
import com.jokerdig.pojo.Goods;
import com.jokerdig.pojo.Record;
import com.jokerdig.pojo.User;
import com.jokerdig.service.GoodsService;
import com.jokerdig.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-17
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private GoodsService goodsService;

    // 自定义分页查询
    @PostMapping("/listPage")
    public Result listPageC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String storage = (String) param.get("storage");
        String goodstype = (String) param.get("goodstype");
        String userId = (String) param.get("userId");
        String roleId = (String) param.get("roleId");

        Page<Record> page = new Page();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        QueryWrapper<Record> lqw = new QueryWrapper();
        lqw.apply("a.goods = g.id"); // 拼接sql,防止多个where报错
        if(name.equals("null")  || StringUtils.isNotBlank(name)){
            lqw.like("g.name",name);
        }
        if(storage.equals("null")  || StringUtils.isNotBlank(storage)){
            lqw.eq("g.storage",storage);
        }
        if(goodstype.equals("null")  || StringUtils.isNotBlank(goodstype)){
            lqw.eq("g.goodstype",goodstype);
        }
        if(roleId.equals("2")){
            lqw.eq("a.userId",userId);
        }

        IPage result = recordService.pageC(page,lqw);
        // System.out.println("总条数："+result.getTotal());
        return Result.suc(result.getRecords(),page.getTotal());
    }
    // 出入库
    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        String status = (String) record.getStatus();
        Goods goods = goodsService.getById(record.getGoods());
        int count = record.getCount();
        if(status.equals("入库")){
            goods.setCount(goods.getCount() + count);
        }else if(status.equals("出库")){
            goods.setCount(goods.getCount() - count);
        }
        goodsService.updateById(goods);
        return recordService.save(record)? Result.suc():Result.fail();
    }

}
