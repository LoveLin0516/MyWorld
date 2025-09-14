package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/24
 * Description: print thread by their order
 * 按照顺序打印线程名
 */
class TestThread4 {

    static class Domio implements Runnable {
        private String str;
        private Thread thread;

        public Domio(String str, Thread thread) {
            this.str = str;
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                this.thread.join();
//                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(str);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"_A", "_B", "_C"};
        Thread pre = Thread.currentThread();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Domio(strs[i], pre));
            thread.start();
            pre = thread;
        }
        System.out.print("begin");

    }
}
