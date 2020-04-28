package com.nj.thread;

/**
 * 解决线程通信问题（生产消费者问题）方法之一：管程法
 * 利用缓冲区作为中间容器
 */

public class CoTest {
    public static void main(String[] args) {
        SynArea1 synArea = new SynArea1();
        new Producer1(synArea).start();
        new Consumer1(synArea).start();

    }

}


//生产者
class Producer extends Thread {
    SynArea1 synArea;

    public Producer(SynArea1 synArea) {
        this.synArea = synArea;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println("生产馒头-->" + i + "个");
            synArea.push(new StreamBun1(i));
        }

    }
}

//消费者
class Consumer extends Thread {
    SynArea1 synArea;

    public Consumer(SynArea1 synArea) {
        this.synArea = synArea;
    }

    @Override
    public void run() {

        for (int i = 1; i < 101; i++) {
            System.out.println("消费馒头-->" + synArea.pull().getId() + "个");

        }
    }
}

//缓冲区
class SynArea {
    private StreamBun1[] streamBuns = new StreamBun1[10];
    int count = 0;//计数器

    //生产馒头
    public synchronized void push(StreamBun1 streamBun) {
        //什么时候生产
        if (count == streamBuns.length) {//缓冲区空间已满
            try {
                this.wait();//线程堵塞，等待消费者通知生产；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //存在空间就生产
        streamBuns[count] = streamBun;
        this.notifyAll();
        count++;
    }

    //消费馒头
    public synchronized StreamBun1 pull() {
        //什么时候消费
        //存在数据就消费
        if (count == 0) {//缓冲区有数据
            try {
                this.wait();//线程堵塞，等待生产者通知消费；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据消费
        count--;
        StreamBun1 streamBun = streamBuns[count];
        this.notifyAll();
        return streamBun;

    }

}


//商品, 假设为馒头

class StreamBun {
    private int id;

    public StreamBun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}