package com.jokerdig.lesson1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:21
 **/
//panel面板
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局概念
       Panel panel= new Panel();
        //设置布局
        frame.setLayout(null);
        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(2,2,2));
        //panel设置坐标小对于frame
        panel.setBounds(50,60,400,400);
        panel.setBackground(new Color(149, 57, 57));
        //添加面板
        frame.add(panel);
        frame.setVisible(true);
        //监听事件 关闭窗口
        //适配器模式
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
              //结束程序
                System.exit(0);
            }
        });

    }

}
