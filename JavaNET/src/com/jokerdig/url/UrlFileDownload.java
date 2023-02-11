package com.jokerdig.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 14:05
 **/
public class UrlFileDownload {
    public static void main(String[] args) throws Exception{
      //下载地址
      URL url = new URL("https://jokerdig.com/images/avatar.png");
      //连接资源
      HttpURLConnection http=(HttpURLConnection) url.openConnection();
        InputStream inputStream = http.getInputStream();
        FileOutputStream file = new FileOutputStream("avatar.png");

        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            file.write(buffer,0,len);//写出数据
        }
        //释放资源
        file.close();
        inputStream.close();
        http.disconnect();//断开
    }
}
