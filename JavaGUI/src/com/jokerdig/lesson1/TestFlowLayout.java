package com.jokerdig.lesson1;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:36
 **/
//流式布局
public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("流式布局");
        //组件按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        //设置流式布局
        //frame.setLayout(new FlowLayout());
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setSize(200,200);

        //添加按钮
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
    }
}
