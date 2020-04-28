package com.nj.thread;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域；
 * 三种方法set、get、initialVaule；设置线程值
 * 数据互不干扰，各自独立
 */

public class ThreadLocalTest {
    //第一种方法，增加匿名内部类,更改初始化值
/*
    private  static ThreadLocal<Integer> tl=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
        return 10;
        }
    };
*/
    //第二种方法hreadLocal.withInitial（lambda方法）
    private static ThreadLocal<Integer> tl=ThreadLocal.withInitial(
            //
            ()->200
            /*()->{
        return  200;
    }*/);



    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"--->"+tl.get());//获取值

        tl.set(20);//更改值
        System.out.println(Thread.currentThread().getName()+"--->"+tl.get());

        //第一种：使用lambda方法实现线程
/*
        new Thread(()->{//互不干扰，数据各自独立
            tl.set(3);
            System.out.println(Thread.currentThread().getName()+"--->"+tl.get());
        }).start();
*/

        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();

    }

    //第二种：静态内部类
    public static class MyThread implements Runnable{

        @Override
        public void run() {
            tl.set((int)(Math.random()*33));
            System.out.println(Thread.currentThread().getName()+"--->"+tl.get());
        }
    }

}
