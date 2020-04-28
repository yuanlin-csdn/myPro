package com.nj.thread;

/**
 * 并发：测试死锁问题；
 * 死锁含义：过多的同步可能导致相互不释放资源，从而导致相互等待，一般发生于同步中持有多个对象的🔒；
 * 避免；不要在同一个代码块中，同时持有多个对象的🔒；
 *
 */

public class DeadLock {
    public static void main(String[] args) {

        MakeUp makeUp1=new MakeUp("张柏芝",0);
        MakeUp makeUp2=new MakeUp("王祖贤",1);
        makeUp1.start();
        makeUp2.start();
    }

}

class   Lipstick {

}

class  Mirror {

}

class MakeUp extends Thread{
    String girl;
    int choice;
   static Mirror mirror=new Mirror();
   static Lipstick lipstick=new Lipstick();



    public MakeUp( String girl, int choice) {
        this.girl = girl;
        this.choice = choice;
    }


    @Override
    public void run() {
        print();
    }

    private void print(){

        if (choice==0){
            synchronized (mirror){
                System.out.println(this.girl+"照镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //放在同一个锁中就会出现死锁问题，
                /*synchronized (lipstick){
                    System.out.println(this.girl+"涂口红");
                }*/
            }
            synchronized (lipstick){
                    System.out.println(this.girl+"涂口红");
                }
        }else{
            synchronized (lipstick){
                System.out.println(this.girl+"涂口红");
                //放在同一个锁中就会出现死锁问题，
                /*synchronized (mirror){
                    System.out.println(this.girl+"照镜子");
                }*/
            }
            synchronized (mirror){
                    System.out.println(this.girl+"照镜子");
                }

        }

    }

}