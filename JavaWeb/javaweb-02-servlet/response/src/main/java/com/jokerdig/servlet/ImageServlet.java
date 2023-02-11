package com.jokerdig.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Joker大雄
 * @data 2022/3/30 - 13:16
 **/
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如何让浏览器3s刷新一次
        resp.setHeader("refresh","3");
        // 在内存中创建图片
        BufferedImage image = new BufferedImage(50, 20, BufferedImage.TYPE_3BYTE_BGR);
        // 得到图片
        Graphics gr=(Graphics2D)image.getGraphics();// 取得画笔
        // 设置图片背景颜色
        gr.setColor(Color.WHITE);
        gr.fillRect(0,0,50,20);
        // 给图写数据
        gr.setColor(Color.BLUE);
        gr.setFont(new Font(null,Font.BOLD,20));
        gr.drawString(makeRandom(),0,20);
        // 告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpg");
        // 浏览器的缓存，我们需要去掉
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        // 把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
    // 生成随机数
    private String makeRandom(){
        Random random = new Random();
        String num = random.nextInt(9999) + "";
        StringBuffer stringBF = new StringBuffer();
        for(int i=0;i<4-num.length();i++){
            stringBF.append("0");
        }
        String back = stringBF.toString()+num;
        return back;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
