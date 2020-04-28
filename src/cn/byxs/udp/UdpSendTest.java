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
 * 定义发送端
 * @author edz
 */
public class UdpSendTest implements Runnable {
    //私有化属性
    private DatagramSocket datagramSocket;
    private int port;
    private DatagramPacket datagramPacket;
    private String toIp;
    private int toPort;
    private BufferedReader bufferedReader;



    //构造器,
    public UdpSendTest(int port, String toIp, int toPort) {
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            datagramSocket = new DatagramSocket(port);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true) {
            //准备数据
            String s;
            try {
                s = bufferedReader.readLine();
                byte[] bytes = s.getBytes();
                //封装资源
                datagramPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIp, this
                        .toPort));
                //发送资源
                datagramSocket.send(datagramPacket);
                if (bytes.equals("exit")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭资源
        datagramSocket.close();
    }

}


