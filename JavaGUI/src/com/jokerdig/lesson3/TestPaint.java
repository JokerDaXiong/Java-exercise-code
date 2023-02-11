package com.jokerdig.lesson3;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 22:45
 **/
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}
//画笔类
class MyPaint extends Frame{

    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }

    //画笔
    public void paint(Graphics g){
       //画笔需要颜色，可以绘画
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
        g.setColor(Color.green);
        g.fillRect(200,200,100,100);
        //养成习惯，画笔用完，还原到最初哟啊色
    }
}


