package com.jokerdig.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 13:56
 **/
public class UrlDemo {
    public static void main(String[] args) throws MalformedURLException {
      URL url=  new URL("https://localhost:8080/helloword/index.jsp?username=name&password=123");
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//主机ip
        System.out.println(url.getPort());//端口
        System.out.println(url.getPath());//文件
        System.out.println(url.getFile());//全路径
        System.out.println(url.getQuery());//参数
    }
}
