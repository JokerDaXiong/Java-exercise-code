package com.jokerdig.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 10:09
 **/
//主窗口
public class DialogDemo extends JFrame {
    public DialogDemo(){
        this.setVisible(true);
        this.setSize(600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JFrame 放东西 容器
        Container container = this.getContentPane();
        //绝对布局
        container.setLayout(null);
        //按钮
        JButton button = new JButton("点击弹出对话框");
        button.setBounds(30,30,200,50);
        container.add(button);
        //点击这个按钮，弹出弹窗
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                new MyDialogDemo();
            }
        });
    }

    public static void main(String[] args) {
        new DialogDemo();
    }
}
//弹窗的窗口
class MyDialogDemo extends JDialog{
    public MyDialogDemo() {
        this.setVisible(true);
        this.setBounds(100,100,500,500);
        // 弹窗默认有关闭监听
        //  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container con = this.getContentPane();
        con.setLayout(null);
        con.add(new Label("这就是一个弹窗"));
    }
}