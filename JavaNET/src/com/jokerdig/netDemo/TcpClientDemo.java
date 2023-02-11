package com.jokerdig.netDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Joker大雄
 * @data 2021/9/2 - 19:33
 **/
//客户端
public class TcpClientDemo {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 要知到服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            //端口号
            int port = 9988;
            //创建一个socket连接
            socket = new Socket(serverIP,port);
            //发送消息IO流
            outputStream = socket.getOutputStream();
            outputStream.write("接收到了字节".getBytes());//转换为字节

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                //释放资源
                if(outputStream!=null){
                    outputStream.close();
                }
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
