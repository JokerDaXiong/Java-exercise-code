package com.jokerdig.netDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Joker大雄
 * @data 2021/9/2 - 19:33
 **/
//服务端
public class TcpServerDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream byteStream = null;
        InputStream inputStream = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            //我得有一个地址
            serverSocket = new ServerSocket(9988);
            //等待客户端连接过来
            socket = serverSocket.accept();
            //读取客户端消息
            inputStream = socket.getInputStream();
        /*    int len;
            while((len=inputStream.read(buffer))!=1){
                String msg=  new String(buffer,0,len);
                System.out.println(msg);
                //这样中文进来会乱码
            }
         */
            //管道流
            byteStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                byteStream.write(buffer, 0, len);
            }
            System.out.println(byteStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源
                if (byteStream != null) {
                    byteStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
