package com.jokerdig.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jokerdig.common.QueryPageParam;
import com.jokerdig.common.Result;
import com.jokerdig.pojo.Storage;
import com.jokerdig.service.StorageService;
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
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    // 新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Storage storage){
        return storageService.saveOrUpdate(storage)?Result.suc():Result.fail();
    }
    // 删除
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return storageService.removeById(id)?Result.suc():Result.fail();
    }
    // 查询仓库
    @GetMapping("/list")
    public Result list(){
        List<Storage> list = storageService.lambdaQuery().list();
        return Result.suc(list);
    }
    // 自定义分页查询
    @PostMapping("/listPage")
    public Result listPageC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");

        Page<Storage> page = new Page();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<Storage> lqw = new LambdaQueryWrapper();
        if(name.equals("null")  || StringUtils.isNotBlank(name)){
            lqw.like(Storage::getName,name);
        }

        IPage result = storageService.pageC(page,lqw);
        // System.out.println("总条数："+result.getTotal());
        return Result.suc(result.getRecords(),page.getTotal());
    }
}
