package com.jokerdig.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JokerdigRandomRule extends AbstractLoadBalancerRule {

    // 自定义 这里所写内容仅供测试和了解自定义 并非实际使用
    private int total = 0; // 被调用次数
    private int currentIndex = 0; // 当前提供服务者


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();// 获取存活的服务
            List<Server> allList = lb.getAllServers();// 获取全部服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            // nt index = chooseRandomInt(serverCount); // 生成区间随机数
            // server = upList.get(index); // 从存活的服务中随机获取一个
            // 自定义
            if(total<5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if(currentIndex>upList.size()-1){
                    currentIndex = 0;
                }
                server = upList.get(currentIndex);
            }


            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

           server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
