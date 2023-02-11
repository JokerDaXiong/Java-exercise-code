package com.jokerdig.demo02;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 18:18
 **/
public class UserServiceProxy implements UserService{

    // 使用代理为每个功能添加日志输出
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void query() {
        log("query");
        userService.query();
    }
    // 日志方法
    public void log(String msg){
        System.out.println("DEBUG:执行了"+msg+"方法");
    }


}
