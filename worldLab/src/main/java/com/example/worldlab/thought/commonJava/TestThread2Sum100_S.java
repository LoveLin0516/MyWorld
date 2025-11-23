package com.example.myworld.thread;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/22
 * Description: four Thread to calculate 100 numbers' count
 * 4个线程打印100个数字之和，并返回结果
 *
 * https://chat.deepseek.com/a/chat/s/872eb502-db4d-4356-8069-26e69b2be5b3
 */
class TestThread2Sum100_S {

    int testArray[] = {1, 2, 3};

    private static int result = 0;

    private static Integer[] integerArray = new Integer[100];

    private static Thread[] threadArray = new Thread[4];

    private static final int NUMBER_COUNT = 100;
    private static final int THREAD_NUM = 4;
    private static int specialNum = 25;

    public static void main(String[] args) {

        int[] temp2 = new int[]{};
        int[] temp3 = new int[100];
        Integer[] temp = new Integer[]{};

        for (int i = 0; i < NUMBER_COUNT; i++) {
            integerArray[i] = i + 1;
            // 0 25 50 75
            if (i % specialNum == 0) {
                temp = new Integer[specialNum];
                temp[i % specialNum] = integerArray[i];
                Thread thread = new Thread(new MyRunnable(temp));
                threadArray[i / specialNum] = thread;
            } else {
                temp[i % specialNum] = integerArray[i];
            }
        }

        for (int i = 0; i < THREAD_NUM; i++) {
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
//            Thread.sleep(100L);
//        } catch (Exception e) {
//
//        }

        System.out.println("result--->" + result);

    }

    private static class MyRunnable implements Runnable {
        private Integer[] array;

        private int sum = 0;

        public int getSum() {
            return sum;
        }

        public MyRunnable(Integer[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            System.out.println("thread--->" + Thread.currentThread().getId());
            int temp = 0;
            if (array != null && array.length > 0) {
                for (int i = 0; i < array.length; i++) {
                    temp += array[i];
                }
                result += temp;
            }
            System.out.println("temp--->" + temp);
        }
    }


}
