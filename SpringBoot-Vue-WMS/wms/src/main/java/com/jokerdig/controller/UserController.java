package com.jokerdig.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jokerdig.common.QueryPageParam;
import com.jokerdig.common.Result;
import com.jokerdig.pojo.Menu;
import com.jokerdig.pojo.User;
import com.jokerdig.service.MenuService;
import com.jokerdig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // 注入UserService
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    // 查询所有
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    // 根据No查询
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        return list.size() > 0 ? Result.suc(list) : Result.fail();
    }

    // 新增
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user) ? Result.suc() : Result.fail();
    }

    // 修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }

    // 新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user) ? Result.suc() : Result.fail();
    }

    // 删除
    @GetMapping("/delete")
    public Result delete(@RequestParam String id) {
        return userService.removeById(id) ? Result.suc() : Result.fail();
    }

    // 查询(模糊 匹配)
    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(user.getName())) {
            lqw.like(User::getName, user.getName());
        }
        return Result.suc(userService.list(lqw));
    }

    // 分页
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        Page<User> page = new Page<>();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
        lqw.like(User::getName, name);
        IPage result = userService.page(page, lqw);
        // System.out.println("总条数："+result.getTotal());
        return result.getRecords();
    }

    // 自定义分页查询
    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String sex = (String) param.get("sex");
        String roleId = (String) param.get("roleId");
        Page<User> page = new Page();
        // 当前页
        page.setCurrent(query.getPageNum());
        // 每页显示条数
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
        if (name.equals("null") || StringUtils.isNotBlank(name)) {
            lqw.like(User::getName, name);
        }
        if (StringUtils.isNotBlank(sex)) {
            lqw.eq(User::getSex, sex);
        }
        if (StringUtils.isNotBlank(roleId)) {
            lqw.eq(User::getRoleId, roleId);
        }
        IPage result = userService.pageC(page, lqw);
        // System.out.println("总条数："+result.getTotal());
        return Result.suc(result.getRecords(), page.getTotal());
    }

    // 登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        // 匹配账号和密码
        List<User> list = userService.lambdaQuery()
                .eq(User::getNo, user.getNo())
                .eq(User::getPassword, user.getPassword()).list();
        // 登录的时候对菜单进行处理
        if (list.size() > 0) {
            User user1 = (User) list.get(0);
            List menuList = menuService.lambdaQuery().like(Menu::getMenuright, user1.getRoleId()).list();
            Map res = new HashMap<>();
            res.put("user", user1);
            res.put("menu", menuList);
            return Result.suc(res);
        }
        return Result.fail();
    }
}
