package com.nj.thread;

import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;

/**
 * 测试
 */
public class ThreadTest {
    public static void main(String[] args) {
        Cinnema cinnema=new Cinnema(10,"开心一刻");
        new Thread(new Customer(3,cinnema),"张三").start();
        new Thread(new Customer(2,cinnema),"李四").start();
        new Thread(new Customer(1,cinnema),"赵武").start();
        new Thread(new Customer(5,cinnema),"王六").start();


    }

}

class  Cinnema {
    int  seats;//有效座位
    String info;//电影院名字

    public Cinnema(int seats, String info) {
        this.seats = seats;
        this.info = info;
    }

    //购票
    public boolean printSeats(int countseats){
        System.out.println("欢迎光临开心一刻影院，现有座位数量为："+seats);
        if (countseats<=seats){
            seats-=countseats;//可用座位
            return true;
        }
        return  false;

    }
}

class   Customer  implements Runnable{
    int countseats;//可选座位
     Cinnema cinnema;//哪家影院

    public Customer(int countseats, Cinnema cinnema) {
        this.countseats = countseats;
        this.cinnema = cinnema;
    }

    @Override
    public void run() {
        synchronized (cinnema){
            boolean flag=cinnema.printSeats(countseats);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                System.out.println(Thread.currentThread().getName()+"-->"+countseats+"票数充足，可预定");
            }else{
                System.out.println(Thread.currentThread().getName()+"-->"+countseats+"票数不足，已卖光");
            }
        }
    }
}