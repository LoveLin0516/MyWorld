package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/22
 * Description: four Thread to calculate 100 numbers' count
 *
 * 线程按照顺序去打印，也可以采用join的方式
 * 同一时间只有一个线程运行
 *
 */
class TestThread2B {

    private static int result = 0;
    private static final Byte lock = 0;
    private static Integer[] integerArray = new Integer[100];
    private static Thread[] threadArray = new Thread[4];

    private static final int NUMBER_COUNT = 100;
    private static final int THREAD_NUM = 4;
    private static int specialNum = 25;

    private static int currentIndex = 0;

    public static void main(String[] args) {

        for (int i = 0; i < NUMBER_COUNT; i++) {
            integerArray[i] = i + 1;
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            threadArray[i] = new Thread(new MyRunnable(i, integerArray));
            threadArray[i].start();
            try {
                threadArray[i].join();
            } catch (InterruptedException exception) {

            }
        }

//        for (int i = 0; i < NUM; i++) {
//            try {
//                threadArray[i].join();
//            } catch (Exception e) {
//            }
//        }

//        try {
//            Thread.sleep(1000L);
//        } catch (Exception e) {
//
//        }

        System.out.println("result--->" + result);

    }

    private static class MyRunnable implements Runnable {
        private Integer[] array;
        private int threadIndex;

        public MyRunnable(int threadIndex, Integer[] array) {
            this.threadIndex = threadIndex;
            this.array = array;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("thread id--->" + Thread.currentThread().getId());
                while (currentIndex != threadIndex) {
                    try {
                        System.out.println("wait thread id--->" + Thread.currentThread().getId());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = 0;
                if (array != null && array.length > 0) {
                    for (int i = threadIndex * specialNum; i < (threadIndex + 1) * specialNum; i++) {
                        temp += array[i];
                    }
                    result += temp;
                    System.out.println("temp--->" + temp);
                }

                currentIndex++;
                lock.notifyAll();
            }
        }
    }
}
