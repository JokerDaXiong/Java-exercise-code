package com.jokerdig.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 12:49
 **/
public class TalkSeed implements Runnable{

    DatagramSocket socket=null;
    BufferedReader reader=null;
    private int fromPort;
    private String toIp;
    private int toPort;
    //构造器
    public TalkSeed(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            //准备数据，控制台读取 System.in
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //循环发送
        while(true){
            String data= null;
            try {
                data = reader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress(this.toIp,this.toPort));
                socket.send(packet);

                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
