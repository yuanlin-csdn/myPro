package cn.nj.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 测试UDP编码：接收端（服务端）多次接收；
 * 1、指定端口，创建接受端--》dataGramSocket；
 * 2、准备容器封装成dataGramPocket数据包裹
 * 3、堵塞式接收dataGramPocket数据包
 * 4、分析包裹：getData（）；
 * 5、关闭资源
 *
 * @author edz
 */
public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动中");
        //1、指定端口，创建接受端--》dataGramSocket；
        DatagramSocket  server =new DatagramSocket(7777);
        //2、准备容器接收dataGramPocket数据包裹
        while(true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、堵塞式接收dataGramPocket数据包
            server.receive(packet);
            //4、分析包裹：getData（）；
            byte[] datas = packet.getData();
            System.out.println(new String(datas, 0, datas.length));
            if (datas.equals("bye")){
                break;
            }
        }
        //5、关闭资源;
        server.close();


    }
}
