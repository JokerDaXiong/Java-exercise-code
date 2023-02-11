package com.jokerdig.snake;

import javax.swing.*;

/**
 * @author Joker大雄
 * @data 2021/8/19 - 11:04
 **/
//游戏主启动类
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇-jokerdig.com");

        frame.setResizable(false);//窗口大小不可变
        frame.setBounds(10,10,900,725);
        //内容在面板中
        frame.add(new GamePanel());
        frame.setVisible(true);//显示界面
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //可关闭

    }
}
