package com.jokerdig.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/7/26 - 11:04
 **/
@Configuration
public class ShiroConfig {

    // ShiroFileFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro内置过滤器
        /*
            anon   无需认证可以访问
            authc  必须认证才能访问
            user   必须拥有记住我功能才能使用
            perms  拥有某个资源的权限才能访问
            role   拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        // 授权
        // user:add  user用户并且拥有add权限才能访问
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        bean.setFilterChainDefinitionMap(filterMap);
        // 设置登录请求
        bean.setLoginUrl("/toLogin");
        // 设置未授权提示
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    // DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    // 创建Realm 对象 需要自定义
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    // 整合ShiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
