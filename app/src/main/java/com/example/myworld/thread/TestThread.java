package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/10
 * Description: test thread about
 */
public class TestThread {
    public static int a = 0;
    private static Object object = new Object();
    public static volatile int cc = 0;

    public static void main(String[] args) {
//        cc = a;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doSleep(200);
                a = 1;
                cc = a;

//                try {
//                    synchronized (object) {
//                        object.wait();
//                    }
//                    object.notify();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
        );
        thread.start();

//        doSleep(300);
//        threadJoin(thread);

        System.out.println("a------>" + a);
        System.out.println("cc------>" + cc);
    }

    private static void doSleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
