package com.nj.thread;

import com.sun.corba.se.impl.orb.ParserTable;
import com.sun.deploy.security.SelectableSecurityManager;

/**
 *自定义手写实现可重入锁，
 * 可重入锁：锁可以延续使用,不会出现死锁问题
 */

public class LockTest01 {
    ReLock reLock =new ReLock();

    public  void  openLight() throws InterruptedException {
        reLock.pushLock();
        System.out.println(reLock.getCount());
        readBook();
        reLock.pullLocked();
        System.out.println(reLock.getCount());

    }
    public void  readBook() throws InterruptedException {

        reLock.pushLock();
        System.out.println(reLock.getCount());
        System.out.println("打开锁");
        reLock.pullLocked();
        System.out.println(reLock.getCount());

    }

    public static void main(String[] args) throws InterruptedException {
        LockTest01 lt=new LockTest01();
        lt.openLight();
        Thread.sleep(1000);
        System.out.println(lt.reLock.getCount());

    }


}

//创建一个可重入锁🔒
/*class ReLock {
    private boolean isLocked=false;//判断锁是否被占用🔒
    Thread t=Thread.currentThread();//存储线程
   private int count;//计数器

    public int getCount(){
        return count;
    }

    //使用🔒
    public synchronized void  pushLock() throws InterruptedException {
        while (isLocked&&t!=Thread.currentThread()){//没锁上且不是当前线程，则🔒被占用;
        wait();
        }//是当前线程，可用锁
            isLocked=true;
            count++;
    }

    //释放🔒
    public synchronized void pullLocked(){
        if (t==Thread.currentThread()){//如果是当前线程🔒逐步释放
            count--;
            if (count==0){//彻底释放
                isLocked=false;
                notify();//唤醒
            }
        }

    }

}*/

//完善版
class ReLock {
    private boolean isLocked=false;//判断锁是否被占用🔒
    Thread lockBy=null;//存储线程
    private int count;//计数器

    public int getCount(){
        return count;
    }

    //使用🔒
    public synchronized void  pushLock() throws InterruptedException {
        Thread t=Thread.currentThread();
        while (isLocked&&lockBy!=t){//没锁上且不是当前线程，则🔒被占用;
            wait();
        }//是当前线程，可用锁
        isLocked=true;
        lockBy=t;
        count++;
    }

    //释放🔒
    public synchronized void pullLocked(){
        if (lockBy==Thread.currentThread()){//如果是当前线程🔒逐步释放
            count--;
            if (count==0){//彻底释放
                isLocked=false;
                notify();//唤醒
                lockBy=null ;
            }
        }

    }

}
