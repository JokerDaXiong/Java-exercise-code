package com.jokerdig.demo01;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 17:18
 **/
// 代理(中介)
public class Proxy implements Rent{
    private Host host;
    public Proxy(){

    }
    public Proxy(Host host){
        this.host = host;
    }

    public void rent() {
       host.rent();
       seeHouse(); // 看房
       fare(); // 收中介费
       contract();// 签合同
    }
    // 看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    // 收中介费
    public void fare(){
        System.out.println("收中介费");
    }
    // 签租赁合同
    public void contract(){
        System.out.println("签写租赁合同");
    }
}
