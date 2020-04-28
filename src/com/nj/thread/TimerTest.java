package com.nj.thread;

import java.util.*;

/**
 * 测试Thread高级主题
 * 定时调度任务 Timer
 * 及Timer task抽象类（内部已自动实现Runnable接口），具备多线程能力
 */
public class TimerTest {
    public static void main(String[] args) {
        //调用Timer对象
        Timer timer =new Timer();
//        timer.schedule(new MyTask(),new Date(1000));//一秒后执行
/*
        timer.schedule(new MyTask(),5000,1000);//5秒后，每隔1秒执行一次；重复执行
*/
        //指定日期📅
        GregorianCalendar calendar=new GregorianCalendar(
                2020,3,17,18,12,30);
        timer.schedule(new MyTask(),calendar.getTime());//指定具体时间定时执行

    }


}

class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("连续学习5个小时，让大脑放松一下啊"+i);
        }
        System.out.println("############");

    }
}