package com.jokerdig.netDemo;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author Joker大雄
 * @data 2021/9/2 - 19:15
 **/
public class Demo2 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress1);

        System.out.println(inetSocketAddress.getAddress());//地址
        System.out.println(inetSocketAddress.getHostName());//域名
        System.out.println(inetSocketAddress.getPort());//端口
    }
}
