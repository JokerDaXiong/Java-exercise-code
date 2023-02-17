package com.jokerdig.controller;


import com.jokerdig.common.Result;
import com.jokerdig.pojo.Menu;
import com.jokerdig.pojo.User;
import com.jokerdig.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    // 查询菜单
    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuright,roleId).list();
        return Result.suc(list);
    }
}
