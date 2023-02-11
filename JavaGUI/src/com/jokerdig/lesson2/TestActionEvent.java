package com.jokerdig.lesson2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 21:14
 **/
public class TestActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发事件
        Frame frame = new Frame();
        Button button = new Button();
        //因为，addActionListener()需要一个ActionListener,我们需要构造ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        windowClose(frame);//关闭窗口
    }

    //关闭窗口
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭窗口
                System.exit(0);
            }
        });
    }
}
//按钮事件监听
class MyActionListener implements ActionListener{

 // 重写方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮点击事件");
    }
}