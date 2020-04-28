package cn.nj.net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;

import static cn.nj.net.IOUtils.fileToByteArray;

/**
 * URL传输
 * 发送端
 * 测试字节数组、基本数据类型、对象类型传输
 * @author edz
 */
public class Cilent {
    public static void main(String[] args) throws Exception {
        //指定发送端口
        DatagramSocket client =new DatagramSocket(5555);
        //准备一定数据转为字节数组

        /*1、字节数组转换*/
       /* String s="努力学习code，走上人生巅峰";
        byte[]bytes=s.getBytes();*/
        /*2、基本数据类型*/
        /*ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeInt(10);
        dos.writeChar('z');
        dos.writeUTF("一把辛酸泪");
        dos.flush();
        byte[]bytes=baos.toByteArray();*/

        /*3、对象类型*/
       /* ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oots =new ObjectOutputStream(new BufferedOutputStream(baos));
        Employee emp= new Employee("马云",9999);
        oots.writeObject(emp);
        oots.writeObject(new Date());
        oots.flush();
        byte []bytes=baos.toByteArray();
*/
        /*4、图片转数组*/
        byte[] bytes=IOUtils.fileToByteArray("src/logo.jpg");


        //封装数据
        DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length,
                new InetSocketAddress("localhost",1111));
        //发送包裹
        client.send(packet);
        //关闭资源
        client.close();
    }

}

class  Employee implements Serializable{
    /**
     * Serializable序列化操作
     * transient表示隐藏该信息
     */
  private transient String name;
  private long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {

        this.salary = salary;
    }


}
