package com.jokerdig.demo2;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 11:32
 **/
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
//结婚接口
interface Marry{
    void HappyMarry();
}
//你实现结婚的接口
class You implements Marry{

    //自己
    @Override
    public void HappyMarry() {
        System.out.println("小王开心的结婚");
    }
}
//婚庆公司
class WeddingCompany implements Marry{

    private Marry target;
    public  WeddingCompany(Marry target){
        this.target = target;
    }
    //代理
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    //结婚前
    private void before() {
        System.out.println("结婚之前");
    }
    //结婚后
    private void after() {
        System.out.println("结婚之后");
    }
}
