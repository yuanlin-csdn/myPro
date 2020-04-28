package cn.nj.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 加入多线程，并封装
 * 测试UDP编码：接收端（服务端）多次接收；
 * 1、指定端口，创建接受端--》dataGramSocket；
 * 2、准备容器封装成dataGramPocket数据包裹
 * 3、堵塞式接收dataGramPocket数据包
 * 4、分析包裹：getData（）；
 * 5、关闭资源
 *
 * @author edz
 */
public class UdpReveive implements Runnable {

    /*私有化属性*/
    private  DatagramSocket server;
    private  String from   ;


    public UdpReveive(int port ,String  from) {
        try {
            server=new DatagramSocket(port);
            this.from=from;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //2、准备容器接收dataGramPocket数据包裹
        while(true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、堵塞式接收dataGramPocket数据包
            try {
                server.receive(packet);
                //4、分析包裹：getData（）；
                byte[] datas = packet.getData();
                int length=packet.getLength();
                String data= new String(datas,0,length);
                System.out.println(this.from+"："+data);
                if (datas.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5、关闭资源;
        server.close();
    }
}
