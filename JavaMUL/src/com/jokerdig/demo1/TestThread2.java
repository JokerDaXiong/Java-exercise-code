package com.jokerdig.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * @author Joker大雄
 * @data 2021/8/20 - 18:46
 **/
//练习Thread,实现多线程同步图片
public class TestThread2 extends Thread {

    private String url;//网路地址
    private String name;//文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 testThread2 = new TestThread2("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor.png");
        TestThread2 testThread2_1 = new TestThread2("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor1.png");
        TestThread2 testThread2_2 = new TestThread2("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor2.png");
        testThread2.start();
        testThread2_1.start();
        testThread2_2.start();
        //并不是按顺序依次下载,是同时执行
        /*下载顺序：
          下载文件名为：autor2.png
          下载文件名为：autor.png
          下载文件名为：autor1.png
         */
    }
}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader异常");
        }
    }
}