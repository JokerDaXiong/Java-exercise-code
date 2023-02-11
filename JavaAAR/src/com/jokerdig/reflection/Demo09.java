package com.jokerdig.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2021/9/10 - 19:58
 **/
//通过反射获取泛型
public class Demo09 {
    public void test1(Map<String,User> map, List<User> list){
        System.out.println("test1");
    }

    public Map<String,User> test2(){
        System.out.println("test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Demo09.class.getMethod("test1", Map.class,List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(" "+genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
             Type[] actual =((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type type : actual) {
                    System.out.println(type);
                }
            }
        }
        method = Demo09.class.getMethod("test2",null);
        Type  genericReturnType=method.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualType =((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type type : actualType) {
                System.out.println(type);
            }
        }

    }
}
