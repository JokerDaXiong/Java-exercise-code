package com.jokerdig.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2022/4/11 - 13:18
 **/
public class TestPage {
    public static void main(String[] args) {
        Frame frame = new Frame("监听器的GUI理解");// 新建窗体
        Panel panel = new Panel(null);// 面板
        frame.setLayout(null);// 设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,123,211));

        panel.setBounds(50,50,200,200);
        panel.setBackground(new Color(183,0,122));
        //添加面板到窗体
        frame.add(panel);
        frame.setVisible(true); // 显示

        // 监听事件理解 一般不这样写
        /*
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("窗口打开事件");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口关闭事件");
                //System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("窗口关闭后事件");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口激活事件");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口未激活事件");
            }
        });
        */
        // 监听关闭事件 一般这样写
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭窗口");
                System.exit(0);
            }
        });
    }
}
