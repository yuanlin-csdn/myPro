package cn.byxs.udp;

/**
 * 在多线程环境下，模拟在线咨询
 */
public class UdpTeacherTest {
    public static void main(String[] args) {
        new  Thread(new UdpReveiveTest("学生",5566)).start();

        new Thread(new UdpSendTest(2233,"localhost",7676)).start();
    }

}
