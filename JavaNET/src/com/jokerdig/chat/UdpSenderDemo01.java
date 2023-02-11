package com.jokerdig.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 10:37
 **/
public class UdpSenderDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据，控制台读取 System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //循环发送
        while(true){
            String data=reader.readLine();

            byte[] bytes = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress("localhost",6666));

            socket.send(packet);
            if(data.equals("bye")){
                break;
            }
        }



    }
}
