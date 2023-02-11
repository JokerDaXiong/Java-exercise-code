package com.jokerdig.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 10:37
 **/
public class UdpServerDemo01 {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            //准备接收包裹
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet);
            //断开
            byte[] data = packet.getData();
            String s = new String(data,0, packet.getLength());//packet.length()会无法停止
            System.out.println(s);
            if(s.equals("bye")){
                break;
            }
        }
        socket.close();//释放资源
    }

}
