package com.jokerdig.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/7/22 - 12:01
 **/
@Configuration
public class DruidConfig {

    // 绑定application.yaml中的spring.datasource
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    // 后台监控
    // 因为springboot内置了servlet容器，没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 后台账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();
        // 增加配置 loginUsername和loginPassword 为Druid配置好的固定参数
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        // 允许访问权限 为空是所有人访问，localhost是只能本机访问
        initParameters.put("allow","");
        // 禁止某人访问 xxxx ip地址
        // initParameters.put("xxxx","192.168.0.1");

        bean.setInitParameters(initParameters); // 设置初始化参数
        return bean;
    }
    // filter 过滤器
    @Bean
    public FilterRegistrationBean webStartFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());
        // 可以过滤的请求
        Map<String,String> initParameters = new HashMap<>();
        // 排除过滤
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        return bean;
    }

}
