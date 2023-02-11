package com.jokerdig.lesson2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 21:58
 **/
//简易计算器
public class TestClac {
    public static void main(String[] args) {
        //启动
        new Calculator().loadFrame();
    }
}
//计算器类
class Calculator extends Frame{
    //属性
    TextField text1,text2,text3;
    //方法
    public void loadFrame(){
        Frame f=new Frame("简易计算器");
        //3个文本框
        text1 = new TextField(10);//字符数
        text2 = new TextField(10);//字符数
        text3 = new TextField(20);//字符数

        //1 个按钮
        Button button = new Button("=");
        //按钮监听事件
        button.addActionListener(new MyCalculatorListener());
        //1 个标签
        Label label = new Label("+");
        //布局
        f.setLayout(new FlowLayout());//流式布局

        f.add(text1);
        f.add(label);
        f.add(text2);
        f.add(button);
        f.add(text3);
        f.pack();//自适应
        f.setVisible(true);//显示布局
        closeWindow(f);//关闭窗口
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
    //监听器类
    //使用内部类简化代码
   private class MyCalculatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //1.获得加数和被加数
            int t1=Integer.parseInt(text1.getText());
            int t2=Integer.parseInt(text2.getText());
            //2.把值运算后放入第三个框
            text3.setText(""+(t1+t2));
            //3.清楚前两个框
            text1.setText("");
            text2.setText("");
        }
    }

}

