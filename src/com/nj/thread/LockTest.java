package com.nj.thread;

/**
 * 不可重入锁：锁不可以连续使用
 * @author：yuanlin
 */

public class LockTest {
    ReLock lock=new ReLock();

    public  void  openLight() throws InterruptedException {
        lock.pushLock();
        readBook();
        lock.pullLocked();

    }
    public void  readBook() throws InterruptedException {

        lock.pushLock();
        System.out.println("打开锁");
        lock.pullLocked();

    }

    public static void main(String[] args) throws InterruptedException {
    LockTest02 lt=new LockTest02();
        lt.openLight();

    }


}

//创建一个lock类
/**/
class Lock {
    //判断锁是否被占用🔒
    private boolean isLocked=false;


    //使用🔒
    public synchronized void  pushLock() throws InterruptedException {
        while (isLocked){
            //没锁上，被占用
        wait();
        } //锁上
        isLocked=true;
    }

    //释放🔒
    public synchronized void pullLocked(){
        isLocked=false;
        notify();


    }

}