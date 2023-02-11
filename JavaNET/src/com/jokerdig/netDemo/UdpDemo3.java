package com.jokerdig.netDemo;

import java.io.IOException;
import java.net.*;

/**
 * @author Joker大雄
 * @data 2021/9/3 - 20:01
 **/
//不需要连接服务器
public class UdpDemo3 {
    public static void main(String[] args) throws IOException {
        //建立一个socket
        DatagramSocket datagramSocket = new DatagramSocket();
        //建个包
        String manage="你好，服务器！";
        //发送的地址
        InetAddress localhost = InetAddress.getByName("localhost");
        int port =9090;
        //数据 数据的长度起始，发送给谁
        DatagramPacket packet = new DatagramPacket(manage.getBytes(),0, manage.getBytes().length, localhost, port);
        //发送包
        datagramSocket.send(packet);
        //释放资源
        datagramSocket.close();
    }
}
