package com.jokerdig.config;

import com.jokerdig.pojo.User;
import com.jokerdig.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Joker大雄
 * @data 2022/7/26 - 11:12
 **/
// 自定以 Realm  extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权");
        // 为用户授权  SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        // 通过认证中SimpleAuthenticationInfo第一个值获取
        User currentUser = (User) subject.getPrincipal();
        // 通过数据库中用户的权限信息来授权
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 通过数据库查到登录用户
        User user = userService.queryUserByName(userToken.getUsername());
        if(user==null){
            return null; //抛出异常 UnknownAccountException
        }
        // 通过当前用户获取session并把user传递到前端
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);
        // 密码认证 shiro来做
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");

    }
}
