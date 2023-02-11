package com.jokerdig.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author Joker大雄
 * @data 2021/8/19 - 11:10
 **/
//游戏面板
    //实现 KeyListener 接口,重写接口方法
    //实现 ActionListener(定时器)接口,重写接口方法
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //定义蛇的数据结构
    int length;//🐍长度
    int[] snakeX = new int[600];//蛇的X坐标
    int[] snakeY = new int[500];//蛇的Y坐标
    //方向
    String direction;//初始方向向右
    //食物的坐标
    int foodX;
    int foodY;
    Random random = new Random();

    //游戏当前的状态:开始，停止
    boolean isStart = false;//默认不开始
    //失败判定
    boolean isFall = false;
    //定时器,200ms = 1s执行一次
    Timer timer=new Timer(200,this);
    //分数定义
    int score;

    //构造器
    public GamePanel(){
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);
        //获得键盘事件
        this.addKeyListener(this);
        //游戏开始
        timer.start();//定时器开启
    }
    //初始化方法
    public void init(){
        length=3;
        snakeX[0]=100; snakeY[0]=100;//头坐标
        snakeX[1]=75; snakeY[1]=100;//第一个身体坐标
        snakeX[2]=50; snakeY[2]=100;//第二个身体坐标
        direction ="R";//初始方向向右
        //随机食物坐标
        foodX=25+25*random.nextInt(34);
        foodY=75+25*random.nextInt(24);
        score=0;
    }

    //绘制面板,游戏中所有东西都用这支画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        //绘制静态面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部广告
        g.fillRect(25,75,850,600);
        //积分绘制
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度 "+length,750,35);
        g.drawString("分数 "+score,750,50);

        //绘制食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //把小蛇画上去,通过方向来判断
        if(direction.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);//头初始化向右
        }else if(direction.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);//方向向左
        }else if(direction.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);//方向向上
        }else if(direction.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);//方向向下
        }
        //绘制身体坐标
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);//身体坐标
        }
        //游戏状态
        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏",300,350);
        }
        //失败绘制
        if(isFall){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,60));//设置字体
            g.drawString("GAME OVER",280,350);
        }
    }

    //键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
       int keyCode = e.getKeyCode();//获得键盘按键
        if(keyCode == KeyEvent.VK_SPACE){
          if(isFall){
              //重新开始
              isFall=false;
              init();
          }else{
              isStart = !isStart;//取反
          }
            repaint();//重新绘制
        }
        //控制小蛇上下左右移动,且小蛇不能直接回头
        if((keyCode == KeyEvent.VK_UP||keyCode == KeyEvent.VK_W)&&!direction.equals("D")){
            direction="U";
        }else if((keyCode == KeyEvent.VK_DOWN||keyCode == KeyEvent.VK_S)&&!direction.equals("U")){
            direction="D";
        }else if((keyCode == KeyEvent.VK_LEFT||keyCode == KeyEvent.VK_A)&&!direction.equals("R")){
            direction="L";
        }else if((keyCode == KeyEvent.VK_RIGHT||keyCode == KeyEvent.VK_D)&&!direction.equals("L")){
            direction="R";
        }
    }
    //定时器监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFall==false) {  //如果游戏开始,就让小蛇动起来
            //身体移动
            for (int i = length - 1; i > 0; i--) {
                //移动，后一截移动到前一截
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            //头控制身体移动
            if (direction.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                //边界判断
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (direction.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                //边界判断
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (direction.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                //边界判断
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (direction.equals("D")){
                snakeY[0] = snakeY[0] + 25;
                //边界判断
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            //吃食物
            if(snakeX[0]==foodX && snakeY[0]==foodY){
                length+=1;//身体长度增加
                score+=10;//分数增加
                //再次随机生成食物
                foodX=25+25*random.nextInt(34);
                foodY=75+25*random.nextInt(24);
            }
            //失败事件,撞到身体
            for (int i = 1; i < length; i++) {
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                    isFall=true;
                }
            }
            repaint();//重绘
        }
        timer.start();//定时器开始
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

