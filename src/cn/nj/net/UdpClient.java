package cn.nj.net;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 测试UDP编码：发送端（客户端）
 * 1、指定端口，创建发送端--》dataGramSocket；
 * 2、准备数据，转为字节数组
 * 3、封装成dataGramPocket数据包裹。指定目的地
 * 4、发送包裹
 * 5、关闭资源
 *
 * @author edz
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中");
        // 1、指定端口，创建发送端--》dataGramSocket；
        DatagramSocket socket = new DatagramSocket(8888);
        //2、创建字节数组
        String s = "从零开始学代码，有朝一日成大佬";
        byte[] bytes = s.getBytes();
        //3、创建dataGramPocket数据包裹
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                new InetSocketAddress("localhost", 7777));
        //4、发送包裹
        socket.send(datagramPacket);
        //5、关闭资源
        socket.close();


    }
}
