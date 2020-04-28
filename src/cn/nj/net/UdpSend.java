package cn.nj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 加入多线程，并封装数据
 * 测试UDP编码：接收端（服务端）多次接收；
 * 1、指定端口，创建接受端--》dataGramSocket；
 * 2、准备容器封装成dataGramPocket数据包裹
 * 3、堵塞式接收dataGramPocket数据包
 * 4、分析包裹：getData（）；
 * 5、关闭资源
 *
 * @author edz
 */
public class UdpSend implements Runnable {

    /*封装属性*/
    private DatagramSocket socket;
    private String toIP;
    private int toPort;
    private BufferedReader br;

    /*构造器*/

    public UdpSend(int port, String toIP, int toPort) {
        try {
            socket = new DatagramSocket(port);
            this.toIP = toIP;
            this.toPort = toPort;
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = br.readLine();
                byte[] bytes = data.getBytes();
                //3、创建dataGramPocket数据包裹
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                        new InetSocketAddress(this.toIP, this.toPort));
                //4、发送包裹
                socket.send(datagramPacket);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        socket.close();

    }
}
