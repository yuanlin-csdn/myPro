package cn.nj.net;

/**
 * 加入多线程，实现在线咨询，模拟即时通讯
 *
 * @author edz
 */
public class UdpTeacher {
    public static void main(String[] args) {
        new Thread(new UdpReveive(4567,"学生")).start();

        new Thread(new UdpSend(3322,"localhost",9911)).start();

    }


}

