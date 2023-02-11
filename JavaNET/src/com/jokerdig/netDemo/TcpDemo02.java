package com.jokerdig.netDemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Joker大雄
 * @data 2021/9/3 - 19:04
 **/
//输出端
public class TcpDemo02 {
    public static void main(String[] args) throws Exception{
        //创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建一个输出流
        OutputStream out = socket.getOutputStream();
        //文件流
        FileInputStream fileInputStream = new FileInputStream(new File("OIP.jpg"));
        //写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len=fileInputStream.read(buffer))!=-1){
            out.write(buffer,0,len);
        }

        //通知服务器，已经传输完了
        socket.shutdownOutput();//传输完毕

        //确定服务器接收完毕，才能断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[2014];
        int len1;
        while((len1=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len1);
        }
        System.out.println(byteArrayOutputStream.toString());
        //关闭资源
        fileInputStream.close();
        out.close();
        socket.close();

    }
}
