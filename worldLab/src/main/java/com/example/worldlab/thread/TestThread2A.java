package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/22
 * Description: four Thread to calculate 100 numbers' count
 */
class TestThread2A {

    private static int result = 0;
    private static final Byte lock = 0;
    private static Integer[] integerArray = new Integer[100];
    private static Thread[] threadArray = new Thread[4];

    private static final int NUMBER_COUNT = 100;
    private static final int THREAD_NUM = 4;
    private static int specialNum = 25;

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
//            synchronized (lock) {
                System.out.println("thread id--->" + Thread.currentThread().getId());
                int temp = 0;
                if (array != null && array.length > 0) {
                    for (int i = threadIndex * specialNum; i < (threadIndex + 1) * specialNum; i++) {
                        temp += array[i];
                    }
                    result += temp;
                    System.out.println("temp--->" + temp);
                }

//            }
        }
    }
}
