package com.nj.thread;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域；
 * 根据上下文分析环境，即启动起点
 * 构造器：哪里调用 就属于哪里，找线程体
 * run方法：本线程自身的；
 */

public class ThreadLocalTest02 {

    private static ThreadLocal<Integer> tl=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    //静态内部类
    public static class  MyLocal implements Runnable{

      public  MyLocal (){
          tl .set(2);
          System.out.println(Thread.currentThread().getName()+"-->"+tl.get());//这是main线程方法
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-->"+tl.get());
            //        new Thread(new MyLocal()xxx).start();如果在线程体内调用则起点就是线程体；
        }
    }

    public static void main(String[] args) {
        new Thread(new MyLocal()).start();//在哪启动起点就算在哪，目前在main主线程，所以起点就在主线程
        new Thread(new MyLocal()).start();//在哪启动起点就算在哪，目前在main主线程，所以起点就在主线程

    }

}
