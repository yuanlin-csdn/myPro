package cn.nj.net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/**
 * URL
 * 测试字节数组、基本数据类型、对象类型传输
 * @author edz
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //指定端口
        DatagramSocket server =new DatagramSocket(1111) ;
        //准备容器
        byte[] datas =new byte[1024*60];
        DatagramPacket datagramPacket =new DatagramPacket(datas,0,datas.length);
        //接收数据
        server.receive(datagramPacket);
        //分析数据

        /*1、字节数组传输*/
        /*byte [] data =datagramPacket.getData();
        int length=datagramPacket.getLength();
        System.out.println(data ,0,length);*/
        /*2、基本类型传输*/
       /* byte [] data =datagramPacket.getData();
        int length=datagramPacket.getLength();
        ByteArrayInputStream bais= new ByteArrayInputStream(data);
        DataInputStream dis=new DataInputStream(new BufferedInputStream(bais));
        int i=dis.readInt();
        char c =dis.readChar();
        String  s= dis.readUTF();
        System.out.println("s-->" + s);*/
        /*3、对象类型传输*/
       /* byte [] data =datagramPacket.getData();
        int length=datagramPacket.getLength();
        ByteArrayInputStream bais=new ByteArrayInputStream(data);
        ObjectInputStream ois= new ObjectInputStream(new BufferedInputStream(bais));
        Object emp=  ois.readObject();
        Object date=  ois.readObject();
        //判断
        if (emp instanceof Employee){
            Employee employee=(Employee) emp;
            System.out.println(employee.getName()+"-->"+employee.getSalary());
        }
        if (date instanceof Date){
            Date date1=(Date)date;
            System.out.println(date1);
        }
*/
        /*4、字节数组转为图片传输*/
        byte [] data =datagramPacket.getData();
        int length=datagramPacket.getLength();
        IOUtils.byteArrayTOFile(data,"copy-logo.jpg");


        //关闭资源
        server.close();





    }

}
