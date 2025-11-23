package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/24
 * Description: print thread by their order
 * 按照顺序打印线程名
 *
 * **题目**：创建三个线程，线程A打印"A"，线程B打印"B"，线程C打印"C"，要求三个线程同时启动，但保证打印顺序总是"A"、"B"、"C"。
 *
 * https://chat.deepseek.com/a/chat/s/e9a23178-ac54-43b2-9fb1-0380ec2a6ebf
 */
class TestThread4PrintJoin_S {

    /**
     * 使用 join() 方法确实可以实现顺序执行，
     * 但不能满足"三个线程同时启动"的要求。
     * 让我解释一下原因和实现方式：
     */
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

    /**
     * **题目**：创建三个线程，线程A打印"A"，线程B打印"B"，线程C打印"C"，
     * 要求三个线程同时启动，但保证打印顺序总是"A"、"B"、"C"。
     */
    public static class SequentialPrint {
        private int state = 0; // 0-A, 1-B, 2-C
        private final Object lock = new Object();

        public static void main(String[] args) {
            SequentialPrint printer = new SequentialPrint();

            Thread threadA = new Thread(printer::printA);
            Thread threadB = new Thread(printer::printB);
            Thread threadC = new Thread(printer::printC);

            // 同时启动三个线程
            threadA.start();
            threadB.start();
            threadC.start();
        }

        public void printA() {
            synchronized (lock) {
                while (state != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print("A");
                state = 1;
                lock.notifyAll();
            }
        }

        public void printB() {
            synchronized (lock) {
                while (state != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print("B");
                state = 2;
                lock.notifyAll();
            }
        }

        public void printC() {
            synchronized (lock) {
                while (state != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print("C");
                state = 0;
                lock.notifyAll();
            }
        }
    }
}
