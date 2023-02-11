package com.jokerdig.untils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Joker大雄
 * @data 2022/6/4 - 21:09
 **/
public class JsonUtils {
    public static String getJson(Object object,String dateFormat){
        // jackson  ObjectMapper 来格式化时间
        ObjectMapper mapper = new ObjectMapper();
        // 关闭默认显示时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        // 使用自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
