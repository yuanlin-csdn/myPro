package com.nj.thread;

import java.util.zip.GZIPOutputStream;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域；
 * 三种方法set、get、initialVaule；设置线程值
 * 每个线程数据互不干扰，各自独立，更改
 */

public class ThreadLocalTest01 {

    private static ThreadLocal<Integer> tl=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };


    public static class  MyLocal implements Runnable{
        @Override
        public void run() {
            Integer integer=tl.get();
            System.out.println(Thread.currentThread().getName()+"得到了-->"+integer);
            tl.set(integer-1);
            System.out.println(Thread.currentThread().getName()+"还剩下-->"+tl.get());
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+tl.get());
        for (int i=0;i<5;i++){
            new Thread(new MyLocal()).start();

        }







    }





}
