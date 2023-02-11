package com.jokerdig.netDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Joker大雄
 * @data 2021/9/3 - 19:13
 **/
//服务端
public class TcpDemo02Server {
    public static void main(String[] args) throws IOException {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞监听，会一致等待客户端连接
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //文件输出
        FileOutputStream receive = new FileOutputStream(new File("OIP.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            receive.write(buffer,0,len);
        }

        //通知客户端接收完毕了
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我接受完毕了".getBytes());
        //关闭资源
        receive.close();
        inputStream.close();
        socket.close();

    }
}
