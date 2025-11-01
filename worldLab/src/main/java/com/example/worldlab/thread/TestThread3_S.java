package com.example.myworld.thread;

import java.util.ArrayList;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/23
 * Description: 2 thread to print jishu and oushu
 * 2个线程 打印100个数中的奇数和偶数
 */
class TestThread3_S {

    private static final ArrayList<Integer> dataList = new ArrayList<>();
    private static int index = 0;
    public static final int TYPE_OU = 0;
    public static final int TYPE_JI = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            dataList.add(i);
        }

        MyThread1 oushuThread = new MyThread1(TYPE_OU);
        MyThread2 jishuThread = new MyThread2(TYPE_JI);

        oushuThread.start();
        jishuThread.start();
    }

    public static class MyThread1 extends Thread {
        private int mType = 0;

        public MyThread1(int type) {
            this.mType = type;
        }

        @Override
        public void run() {
            System.out.println("MyThread OU------->run");
            synchronized (dataList) {
                System.out.println("num--oushu--->start");
                while (index < 100) {
                    System.out.println("MyThread OU----index--->" + index);

                    if (mType == TYPE_OU && index % 2 == 0) {
                        System.out.println("num--oushu--->" + dataList.get(index));
                        index++;
                        dataList.notify();
                    } else {
                        try {
                            System.out.println("num--oushu--->wait");
                            dataList.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                System.out.println("num--oushu--->end");
            }

        }
    }

    public static class MyThread2 extends Thread {
        private int mType = 0;

        public MyThread2(int type) {
            this.mType = type;
        }

        @Override
        public void run() {
            System.out.println("MyThread JI------->run");
            synchronized (dataList) {
                System.out.println("num--jishu--->start");
                while (index < 100) {
                    System.out.println("MyThread JI----index--->" + index);
                    if (mType == TYPE_JI && index % 2 != 0) {
                        System.out.println("num--jishu--->" + dataList.get(index));
                        index++;
                        dataList.notify();
                    } else {
                        try {
                            System.out.println("num--jishu--->wait");
                            dataList.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                System.out.println("num--jishu--->end");

            }

        }
    }
}
