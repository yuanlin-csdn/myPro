package com.nj.thread;

/**
 * 解决线程通信问题（生产消费者问题）方法之一：信号灯法🚥
 * 借助标识位进行判断
 *
 */

public class CoTest2 {
    public static void main(String[] args) {

        TV tv=new TV();
        new Actor(tv).start();
        new Watcher(tv).start();


    }

}

//生产者  演员
class Actor extends Thread{
    TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            if (i%2==0){
                tv.play("看爱情公寓");
            }else {
                tv.play("好污啊");
            }
        }

    }
}

//消费者  观众
class Watcher extends Thread{
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            tv.watch();
        }

    }
}



//同一份资源 电视
class TV{
    String voice;
    //信号灯
    //T 表示演员表演，观众等待
    //F 表示观众观看，演员等待
    boolean flag=true ;

    //生产者 演员
    public synchronized void play(String voice){

        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        this.voice=voice;
        System.out.println("表演"+voice);
        //唤醒
        this.notifyAll();
        //切换标识符
        this.flag=!this.flag;
    }

    //消费者  观众
    public  synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice=voice;
        System.out.println("听到"+voice);
        //唤醒
        this.notifyAll();
        //切换标识符
        this.flag=!this.flag;
    }
}


