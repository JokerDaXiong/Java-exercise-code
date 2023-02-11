package com.jokerdig.lesson2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 21:25
 **/
public class TestActionEventTwo {
    public static void main(String[] args) {
        //两个按钮实现同一个监听
        //开始   停止
        Frame frame =new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        //可以显示的定义触发会返回的命令
        button2.setActionCommand("定义事件");

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        closeWindow(frame);//关闭窗口


    }
    //关闭窗口
    public static void closeWindow(Frame frame){
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
               //关闭
                System.exit(0);
            }
        });
    }
}


class MyMonitor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //
        System.out.println("按钮被点击了:msg"+e.getActionCommand());
    }
}
