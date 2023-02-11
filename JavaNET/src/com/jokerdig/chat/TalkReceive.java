package com.jokerdig.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 13:23
 **/
public class TalkReceive implements Runnable{
    DatagramSocket socket=null;
    DatagramPacket packet=null;
    private int port;
    private String fromMsg;

    public TalkReceive(int port,String fromMsg) {
        this.port = port;
        this.fromMsg = fromMsg;
        try {
            socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true){
            //准备接收包裹
            try {
                byte[] bytes = new byte[1024];
                packet = new DatagramPacket(bytes,0,bytes.length);
                socket.receive(packet);
                //断开
                byte[] data = packet.getData();
                String s = new String(data,0, packet.getLength());//packet.length()会无法停止
                System.out.println(fromMsg+"发送："+s);
                if(s.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();//释放资源
    }
}
