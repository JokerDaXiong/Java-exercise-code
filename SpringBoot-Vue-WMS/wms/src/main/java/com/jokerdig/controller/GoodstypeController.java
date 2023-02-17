package com.jokerdig.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jokerdig.common.QueryPageParam;
import com.jokerdig.common.Result;
import com.jokerdig.pojo.Goodstype;
import com.jokerdig.service.GoodstypeService;
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
 * @since 2023-01-14
 */
@RestController
@RequestMapping("/goodstype")
public class GoodstypeController {

    @Autowired
    private GoodstypeService goodstypeService;

    // 新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Goodstype goodstype){
        return goodstypeService.saveOrUpdate(goodstype)?Result.suc():Result.fail();
    }
    // 删除
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return goodstypeService.removeById(id)?Result.suc():Result.fail();
    }

    // 查询物品分类
    @GetMapping("/list")
    public Result list(){
        List<Goodstype> list = goodstypeService.lambdaQuery().list();
        return Result.suc(list);
    }
    // 自定义分页查询
    @PostMapping("/listPage")
    public Result listPageC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");

        Page<Goodstype> page = new Page();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<Goodstype> lqw = new LambdaQueryWrapper();
        if(name.equals("null") || StringUtils.isNotBlank(name)){
            lqw.like(Goodstype::getName,name);
        }

        IPage result = goodstypeService.pageC(page,lqw);
        // System.out.println("总条数："+result.getTotal());
        return Result.suc(result.getRecords(),page.getTotal());
    }
}
