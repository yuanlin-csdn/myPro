package com.nj.thread;

/**
 * Dcl单例模式：这里介绍懒汉式套路基础上加入并发控制；利用doubleChecking 和 volatile；
 * 保证在多线程环境下，对外只存在一个对象
 * 1、首先构建私有的构造器--》避免外部new 构造器
 * 2、提供私有的静态属性---》存储对象的地址
 * 3、提供公共的静态方法---》获取属性（对象的地址）
 *
 */

public class DoubleCheckingLock {
    //2、私有静态属性
    private volatile static DoubleCheckingLock instance;
    //这里使用volatie可以避免指令重排，使线程可见性，将修改的变量迅速返回主内存，保持变量同步；
    //没有使用volatile其他线程线程可能会访问一个没有初始化的对象

    //1、私有构造器
    private DoubleCheckingLock(){

    }

    //3、提供公共的方法
    public static DoubleCheckingLock getInstance() {//对外返回同一个对象
        if (null!=instance){//double checking,双重检测，是否已经存在对象，避免不必要的等待
            return instance;
        }
        synchronized (DoubleCheckingLock.class) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (null == instance) {//创建对象
                instance = new DoubleCheckingLock();//创建对象步骤：1、分配对象空间；2、初始化对象值；3、返回对象地址给引用
                //这里存在指令重排，可能导致返回空的对象
            }
        }
        return instance;
    }

    public static DoubleCheckingLock getInstance1() {//出现问题，对外返回多个对象；可以加入参数看的更清楚long time
        //创建对象
            if (null == instance) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //创建对象步骤：1、分配对象空间；2、初始化对象值；3、返回对象地址给引用
                //这里存在指令重排，可能导致返回空的对象
                instance = new DoubleCheckingLock();

            }
        return instance;
    }

    public static void main(String[] args) {


        Thread thread=new Thread(()->{
            System.out.println(DoubleCheckingLock.getInstance());
        });

        thread.start();
        Thread thread1=new Thread(()->{
            System.out.println(DoubleCheckingLock.getInstance());
        });
        thread1.start();



    }


}

