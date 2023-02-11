package com.jokerdig.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Joker大雄
 * @data 2022/7/23 - 12:14
 **/
// 启动Security
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   //   这里仅用旧版做演示
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                // 指定登录页面
                .loginPage("/toLogin")
                // 登录认证url
                .loginProcessingUrl("/usr/login")
                // 账号和密码接收
                .usernameParameter("username")
                .passwordParameter("password")
                // 不同的功能之间用and()连接
                .and()
                // 权限
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 注销功能 注销成功跳转到首页
        http.logout().logoutSuccessUrl("/");
        // 开启记住账号功能 cookie 默认保持两周
        http.rememberMe().rememberMeParameter("remember");
        // 关闭CSRF防护 (仅为测试使用，正是开发不会关闭的)
        http.csrf().disable();
    }
    // 这个方法在在新版本失效了，这里仅作演示
    // 密码编码 passwordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");;
    }
    /**
     旧版本的两个方法
     configure(HttpSecurity)
     configure(WebSecurity)
     新版本的代替
     @Bean
     SecurityFilterChain
     @Bean
     WebSecurityCustomizer
     **/

    // 链式编程 设置访问权限 通过  SecurityFilterChain 这是新的写法
    // 新的写法不需要  extends WebSecurityConfigurerAdapter
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                 // 新版formLogin的写法
//                .formLogin()
//                // 自定义用户名密码
//                .usernameParameter("admin")
//                .passwordParameter("123456")
//                // 不同的功能之间用and()连接
//                .and()
//                // 权限
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/level1/**").hasRole("vip1")
//                .antMatchers("/level2/**").hasRole("vip2")
//                .antMatchers("/level3/**").hasRole("vip3");
//                return http.build();
//    }

}
