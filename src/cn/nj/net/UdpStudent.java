package cn.nj.net;

/**
 *加入多线程，实现在线咨询，模拟即时通讯
 * @author edz
 */
public class UdpStudent {
    public static void main(String[] args) {
        new Thread(new UdpSend(5678,"localhost",4567)).start();

        new Thread(new UdpReveive(9911,"老师")).start();//接收

    }
}
