package cn.byxs.udp;

/**
 * 在多线程环境下，利用UDp传输协议模拟在线咨询
 *
 */

public class UdpStudentTest {
    public static void main(String[] args) {
        new Thread(new UdpSendTest(4345,"localhost",5566)).start();

        new Thread(new UdpReveiveTest("老师",7676)).start();
    }
}
