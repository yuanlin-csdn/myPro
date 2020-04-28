package com.nj.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> seats =new ArrayList<>();
        seats.add(1);
        seats.add(2);
        seats.add(3);
        seats.add(15);
        seats.add(13);
        seats.add(8);

        List<Integer> countSeats =new ArrayList<>();
        countSeats.add(1);
        countSeats.add(2);

        List<Integer> countSeats1 =new ArrayList<>();
        countSeats1.add(3);
        countSeats1.add(15);

        List<Integer> countSeats2 =new ArrayList<>();
        countSeats2.add(13);
        countSeats2.add(8);

        List<Integer> countSeats3 =new ArrayList<>();
        countSeats3.add(8);

        HappyCinema cinema=new HappyCinema(seats,"开心一刻");
        new Thread(new Customer1(countSeats,cinema),"李四").start();
        new Thread(new Customer1(countSeats1,cinema),"赵武").start();
        new Thread(new Customer1(countSeats2,cinema),"王六").start();
        new Thread(new Customer1(countSeats3,cinema),"孙启").start();


    }

}

class HappyCinema {
    List<Integer> seats;//有效座位
    String info;//电影院名字

    public HappyCinema(List<Integer> seats, String info) {
        this.seats = seats;
        this.info = info;
    }

    //购票
    public boolean printSeats(List<Integer> countSeats){
        System.out.println("欢迎光临开心一刻影院，现有座位数量为："+seats);
        //拷贝
        List<Integer> copy=new ArrayList<>();
        copy.addAll(seats);

        //去交集；
        copy.removeAll(countSeats);

        if (seats.size()-copy.size()==countSeats.size()){
        seats=copy;
        return  true;

        }else{
            return  false;
        }
    }

}

class   Customer1  implements Runnable{
    List<Integer> countSeats;//可选座位
    HappyCinema cinema;//哪家影院

    public Customer1(List<Integer> countSeats, HappyCinema cinema) {
        this.countSeats = countSeats;
        this.cinema = cinema;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag= cinema.printSeats(countSeats);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                System.out.println(Thread.currentThread().getName()+"-->"+ countSeats +"票数充足，可预定");
            }else{
                System.out.println(Thread.currentThread().getName()+"-->"+ countSeats +"票数不足，已卖光");
            }
        }
    }
}

