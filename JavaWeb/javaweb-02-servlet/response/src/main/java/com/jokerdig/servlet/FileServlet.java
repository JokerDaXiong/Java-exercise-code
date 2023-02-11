package com.jokerdig.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Joker大雄
 * @data 2022/3/30 - 12:43
 **/
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String realPath = "D:\\Project\\project3\\JavaWeb\\javaweb-02-servlet\\response\\target\\classes\\1.png";
        System.out.println("下载文件的路径"+realPath);
        // 下载文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 设置浏览器以支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        // 获取下载文件的输入流
        FileInputStream input = new FileInputStream(realPath);
        // 创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];
        // 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        // 将FileOutputStream流写入到Buffer缓冲区
        while((len=input.read(buffer))>0){
            out.write(buffer,0,len);
        }
        // 使用OutputStream将缓冲区中的数据输出到客户端
        input.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
