package com.jokerdig.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jokerdig.common.QueryPageParam;
import com.jokerdig.common.Result;
import com.jokerdig.pojo.Goods;
import com.jokerdig.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-16
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    // 新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Goods goods){
        return goodsService.saveOrUpdate(goods)?Result.suc():Result.fail();
    }
    // 删除
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return goodsService.removeById(id)?Result.suc():Result.fail();
    }

    // 自定义分页查询
    @PostMapping("/listPage")
    public Result listPageC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String storage = (String) param.get("storage");
        String goodstype = (String) param.get("goodstype");

        Page<Goods> page = new Page();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<Goods> lqw = new LambdaQueryWrapper();
        if(name.equals("null")  || StringUtils.isNotBlank(name)){
            lqw.like(Goods::getName,name);
        }
        if(storage.equals("null")  || StringUtils.isNotBlank(storage)){
            lqw.eq(Goods::getStorage,storage);
        }
        if(goodstype.equals("null")  || StringUtils.isNotBlank(goodstype)){
            lqw.eq(Goods::getGoodstype,goodstype);
        }

        IPage result = goodsService.pageC(page,lqw);
        // System.out.println("总条数："+result.getTotal());
        return Result.suc(result.getRecords(),page.getTotal());
    }
}
