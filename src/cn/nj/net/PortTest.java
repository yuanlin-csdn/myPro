package cn.nj.net;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.net.InetSocketAddress;

/**
 * 测试端口：Port;定位软件
 * 用来区分软件
 * 2个字节，大小0-65535之间；UDP、TCP
 * 同一个协议中端口不能冲突
 * 定义端口越大越好
 * 使用InetSockAdress类：
 * 1、构造器：new InetSocketAddress（地址|域名，端口）；
 * 2、方法：
 * getAddress();
 * getPort();
 * getHostNmae();
 *
 *
 * @author edz
 */
public class PortTest {
    public static void main(String[] args) {
        //InetSocketAddress访问主机对象端口和地址
        InetSocketAddress inetSocketAddress =new InetSocketAddress("localhost",9000);
        InetSocketAddress inetSocketAddress1 =new InetSocketAddress("127.0.0.1",8080);

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getPort());
        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getPort());
    }




}
