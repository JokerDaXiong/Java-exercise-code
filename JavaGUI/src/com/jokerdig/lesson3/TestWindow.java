package com.jokerdig.lesson3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 23:28
 **/
public class TestWindow {
    public static void main(String[] args) {
        new windowFrame();
    }
}
class windowFrame extends Frame{

    public windowFrame(){
        setBackground(Color.BLUE);
        setBounds(100,100,200,200);
        setVisible(true);
       // addWindowListener(new MyWindowListener());
        //匿名内部类
        this.addWindowListener(new WindowAdapter() {



            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                windowFrame f = (windowFrame) e.getSource();
                f.setTitle("被激活了");
                System.out.println("windowActivated");
            }
        });
    }
    //继承实现类，来避免实现接口重写太多方法
    class MyWindowListener extends WindowAdapter{

        @Override
        public void windowClosing(WindowEvent e) {
           //隐藏窗口
            setVisible(false);

            //关闭窗口
            System.exit(0);
        }
    }

}
