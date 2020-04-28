package com.nj.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread 高级主题 CAS乐观锁（compare and swap  比较并交换）：不加锁，而是假设没有冲突去完成某项操作，如果操作失败就重试，直到成功为止；
 * 三个关键值：当前内存值v，预期值A，待更新的值B；将V与A比较，相等则用B值将A覆盖；
 * 它属于CPU的CAS指令，是一组原子操作，不会被外部打断，借助JNI来完成非阻塞算法，效率要比加🔒锁操作高；
 * 锁分为两类，一类是悲观锁，就是指synchronized独占锁：其他需要🔒的线程则全部挂起，等待持有锁的线程释放🔒
 */

public class CAS {
    //库存
    private static AtomicInteger stock = new AtomicInteger(5);//假设现有5件库存商品

    public static void main(String[] args) {
       for (int i=0;i<7;i++){
           try {
               Thread.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           Integer left=stock.decrementAndGet();//GPU内部实现CAS操作
           new Thread(()->{
               if (left<0){
                   System.out.println("抢完了");
                   return;
               }
               System.out.print(Thread.currentThread().getName()+"抢了一件商品");
               System.out.println("还剩下"+left);
           }).start();
       }



    }


}
