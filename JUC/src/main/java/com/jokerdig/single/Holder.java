package com.jokerdig.single;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 10:51
 **/
// 静态内部类
public class Holder {
    // 构造器私有
    private Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
