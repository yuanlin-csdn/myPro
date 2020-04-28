package cn.nj.net;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author edz
 * 测试网络编程：IP、Port、URL
 * IP：定位一个节点：通信、路由器、通信设备等
 * InetAddress类：
 * 1、getLocalHost： 本机
 * 2、getByName： 根据域名DNS/IP地址 --》IP；
 * 两个成员方法：
 * InetAddress.getHostAddress（）：返回地址
 * InetAddress.getHostName（）：返回计算机名
 */
public class InetTest {
    public static void main(String[] args) throws UnknownHostException {
        //通过使用getLocalHost获取本机ip地址和用户名
        InetAddress iads= InetAddress.getLocalHost();
        //获取本机IP地址
        System.out.println(iads.getHostAddress());
        //获取本机用户名
        System.out.println(iads.getHostName());

        //通过域名访问InetAddress对象
        InetAddress inetAddress=InetAddress.getByName("www.baidu.com");
        //获取IP地址
        System.out.println(inetAddress.getHostAddress());
        //获取用户名
        System.out.println(inetAddress.getHostName());

        //通过ip地址访问InetAddress对象
        InetAddress inetAddress1=InetAddress.getByName("36.152.44.96");
        //获取IP地址
        System.out.println(inetAddress1.getHostAddress());
        //无法获得域名；如果这个IP地址不存在或者NDS服务器不允许进行ip地址和域名的映射，那么getHostName只能返回ip地址
        System.out.println(inetAddress1.getHostName());


    }





}
