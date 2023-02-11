package com.jokerdig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Joker大雄
 * @data 2022/7/28 - 12:04
 **/
@Configuration
@EnableSwagger2 // 开启swagger2
public class SwaggerConfig {

//    // group A
//    @Bean
//    public Docket docket1(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//    // group B
//    @Bean
//    public Docket docket2(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }
//    // group C
//    @Bean
//    public Docket docket3(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
//    }



    // 配置Swagger的Docket @Bean实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要返回的环境
        Profiles profiles = Profiles.of("dev");
        // 获取项目环境
        boolean flag = environment.acceptsProfiles(profiles);



        return new Docket(DocumentationType.SWAGGER_2)
                // 配置apiInfo
                .apiInfo(apiInfo())
                // 设置组名
                .groupName("组名")


                // 是否开启swagger true开启 false关闭
                // 这里通过flag返回的布尔值来监听，并根据环境打开或关闭swagger
                .enable(flag)
                // 配置扫描接口 RequestHandlerSelectors
                // 通过basePackage() 指定要扫描的包
                // any() 扫描全部
                // none() 不扫描
                // withClassAnnotation() 扫描类上的注解
                // withMethodAnnotation() 扫描方法上的注解
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.jokerdig.controller"))
                // paths() 过滤路径
                // .paths(PathSelectors.ant("/jokerdig/**"))
                .build()
                ;
    }
    // 配置Swagger信息 apiInfo
    private ApiInfo apiInfo(){
        return new ApiInfo("Jokerdig.com Swagger AIP", "一个代码小白的成长", "1.0", "https://jokerdig.com",
                new Contact("JokerDaxiong", "https://jokerdig.com", "xxx@gmail.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    }



}
