package com.opp.demo04;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 13:41
 **/
//abstact 抽象类  extends 单继承(接口可以多继承)
public abstract class Action {
    //约束，有人帮我们实现
    public abstract void doSomething();

    // 1. 不能new这个抽象类，只能考子类去实现它：约束。
    // 2. 抽象类中可以写普通方法
    // 3. 抽象方法必须在抽象类中
    //抽象的抽象：约束
    //思考： 抽象方法存在构造器吗？
}
