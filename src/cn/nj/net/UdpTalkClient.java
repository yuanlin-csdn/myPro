package cn.nj.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 测试UDP编码：发送端（客户端）；多次发送
 * 注意：同一个端口协议下，不可以使用同一个端口号
 * 1、指定端口，创建发送端--》dataGramSocket；
 * 2、准备数据，转为字节数组
 * 3、封装成dataGramPocket数据包裹。指定目的地
 * 4、发送包裹
 * 5、关闭资源
 *
 * @author edz
 */
public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中");
        // 1、指定端口，创建发送端--》dataGramSocket；

        DatagramSocket socket = new DatagramSocket(8888);
        //2、准备一定数据转为字节数组
        /*使用sacnner或者BufferedReader;自定义发送*/
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String data = br.readLine();
            byte[] bytes = data.getBytes();

            //3、创建dataGramPocket数据包裹
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                    new InetSocketAddress("localhost", 7777));
            //4、发送包裹
            socket.send(datagramPacket);
            if (data.equals("bye")){
                break;
            }
        }

        //5、关闭资源
        socket.close();


    }
}
