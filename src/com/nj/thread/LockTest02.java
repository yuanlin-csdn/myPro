package com.nj.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：锁可以延续使用+计数器
 * 可以直接从util包中导入使用ReentrantLock；
 */

public class LockTest02 {
    ReentrantLock lock=new ReentrantLock();

    public  void  openLight() throws InterruptedException {
       lock.lock ();
        System.out.println(lock.getHoldCount());
        readBook();
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }
    public void  readBook() throws InterruptedException {

        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("打开锁");//工作中自己写的代码。。。。。。举个例子
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }

    public static void main(String[] args) throws InterruptedException {
    LockTest02 lt=new LockTest02();
        lt.openLight();

        Thread.sleep(1000);
        System.out.println(lt.lock.getHoldCount());
    }


}

