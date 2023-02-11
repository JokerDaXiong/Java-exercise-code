package com.jokerdig.demo01;

import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 17:16
 **/
// 租客
public class Client {
    @Test
    public void test(){
        // 房东要租房子
       Host host = new Host();
       // 不通过代理直接租房
       // host.rent();
        // 通过代理租房 代理可以收中介费看房等等
        Proxy proxy = new Proxy(host);
        // 租客找中介租房
        proxy.rent();
    }
}
