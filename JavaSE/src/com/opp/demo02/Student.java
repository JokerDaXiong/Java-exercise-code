package com.opp.demo02;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 12:32
 **/
public class Student extends Person{

  @Override
  public void run(){
      System.out.println("run");
  }

  public void eat(){
      System.out.println("eat");
  }

  public void go(){
      System.out.println("go");
  }

}
