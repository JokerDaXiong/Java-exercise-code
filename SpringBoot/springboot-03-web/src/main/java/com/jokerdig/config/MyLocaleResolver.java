package com.jokerdig.config;

import org.apache.tomcat.jni.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Joker大雄
 * @data 2022/7/19 - 14:58
 **/
// 地区解析器
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault(); // 如果没有就默认
        // 如果不为空就使用我们传递的
        if(!StringUtils.isEmpty(language)){
            // zh_CN
            String[] split = language.split("_");
            // 国家 地区
            locale = new Locale(split[0],split[1]);
            return locale;
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
