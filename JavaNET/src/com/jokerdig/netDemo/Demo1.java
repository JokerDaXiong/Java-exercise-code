package com.jokerdig.netDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Joker大雄
 * @data 2021/9/1 - 22:09
 **/
//测试ip
public class Demo1 {
    public static void main(String[] args) {

        try {
            //查询本地地址,127，0.0.1 / localhost/getLocalHost()
            InetAddress byName = InetAddress.getByName("127.0.0.1");
           //查询网络IP地址
            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            InetAddress byName2 = InetAddress.getByName("www.jokerdig.com");
           //输出
            System.out.println(byName);
            System.out.println(byName1);
            System.out.println(byName2);
            //常用方法
            System.out.println(byName2.getCanonicalHostName());//规范的名字
            System.out.println(byName2.getHostAddress());//ip
            System.out.println(byName2.getHostName());//域名，或自己电脑名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
