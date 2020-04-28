package cn.byxs.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 模拟在线咨询。多线程环境下
 * 面向对象封装数据
 * 定义接收端
 * @author edz
 */
public class UdpReveiveTest implements Runnable {
    private int port;
    private DatagramSocket socket;
    private  String from;

    public UdpReveiveTest(String form,int port) {
        this.from=form;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            //准备接收容器
            byte[] data = new byte[1024 * 60];
            DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length);
            //阻塞式接收资源
            try {
                socket.receive(datagramPacket);
                //分析资源
                byte[] datas = datagramPacket.getData();
                int length = datagramPacket.getLength();
                String info=new String(datas,0,length);
                //增加数据来源处
                System.out.println(this.from+":"+info);
                if (info.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //关闭资源
        socket.close();
    }
}

