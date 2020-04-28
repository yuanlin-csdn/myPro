package com.nj.thread;

/**
 * InheritableThreadLocal:继承上下文分析环境的数据，拷贝一份数据给子线程；
 * 构造器：哪里调用 就属于哪里，找线程体
 * run方法：本线程自身的；
 */

public class ThreadLocalTest03 {
    //初始化
    private static ThreadLocal<Integer> tl = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        tl.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + tl.get());

        //此线程由main开辟
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->" + tl.get());//通过InheritableThreadLocal可以继承一次main主线程的值
            tl.set(10);//可以随意再次设值
            System.out.println(Thread.currentThread().getName() + "-->" + tl.get());

        }).start();

    }

}
