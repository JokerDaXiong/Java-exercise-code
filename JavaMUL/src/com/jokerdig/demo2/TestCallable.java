package com.jokerdig.demo2;

import com.jokerdig.demo1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 11:18
 **/
//线程创建方式三：实现Callable
public class TestCallable implements Callable<Boolean> {


    private String url;//网路地址
    private String name;//文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor.png");
        TestCallable t2 = new TestCallable("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor1.png");
        TestCallable t3 = new TestCallable("https://cdn.jsdelivr.net/gh/JokerDaxiong/JokerDaxiong.github.io@main/images/avatar.png", "autor2.png");

      //  1. 创建执行服务：
        ExecutorService service = Executors.newFixedThreadPool(3);
      //  2. 提交执行：
        Future<Boolean> result1 = service.submit(t1);
        Future<Boolean> result2 = service.submit(t2);
        Future<Boolean> result3 = service.submit(t3);
      //  3. 获取结果：
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
       // 4. 关闭服务：
        service.shutdownNow();
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