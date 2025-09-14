package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/11
 * Description:
 */

/**
 * 4.M根绳子最长长度**
 * 有N根绳子，第i根绳子的长度为Li，现在需要M根等长的绳子，
 * 可以对N根绳子进行任意裁剪但不能拼接，那么这M根绳子的最长长度是多少。
 * - https://blog.csdn.net/weixin_37693928/article/details/88794816
 */

class TestRope {
    public static void main(String[] args) {


        int[] array2 = {3, 4, 5};

        double maxLengthDouble2 = getMaxLengthDouble(array2, 4);
        System.out.println("getMaxLengthDouble------>" + maxLengthDouble2);

        int maxLengthInteger2 = getMaxLengthInteger(array2, 4);
        System.out.println("getMaxLengthInteger------>" + maxLengthInteger2);

        int[] array3 = {2, 3, 5};

        double maxLengthDouble3 = getMaxLengthDouble(array3, 6);
        System.out.println("getMaxLengthDouble------>" + maxLengthDouble3);

        int maxLengthInteger3 = getMaxLengthInteger(array3, 6);
        System.out.println("getMaxLengthInteger------>" + maxLengthInteger3);

        int[] array1 = {1, 2, 3, 4};

        double maxLengthDouble = getMaxLengthDouble(array1, 5);
        System.out.println("getMaxLengthDouble------>" + maxLengthDouble);

        int maxLengthInteger = getMaxLengthInteger(array1, 5);
        System.out.println("getMaxLengthInteger------>" + maxLengthInteger);

//        int result = 0;
//        int[] tempArray = array3;
//        for (int i = 0; i < tempArray.length; i++) {
////            tempArray[i] = tempArray[i] * 100;
//            result += tempArray[i] / (maxLength + 14);
//        }
//        System.out.println("result---3--->" + result);
    }

    /**
     * **4.M根绳子最长长度**
     * 有N根绳子，第i根绳子的长度为Li，现在需要M根等长的绳子，
     * 可以对N根绳子进行任意裁剪但不能拼接，那么这M根绳子的最长长度是多少。
     * - https://blog.csdn.net/weixin_37693928/article/details/88794816
     */
    // 5根，2 4 6 8 10    x  m
    // int m = 5;
    // int[] array = {2, 4, 6, 8, 10};
    //
    public static int getMaxLengthInteger(int[] array, int m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 100;
        }
        int res = -1;
//        int min = array[0];
        int min = 0;
        int max = array[array.length - 1];

        while (min <= max && (max - min > 1)) {
            int mid = min + (max - min) / 2;
            int result = 0;
            for (Integer value : array) {
                result += value / mid;
            }
            if (result >= m) {
                min = mid;
                res = mid;
            } else {
                max = mid;
            }
        }

        return res;
    }

    public static double getMaxLengthDouble(int[] array, int m) {

        double res = -1;
//        int min = array[0];
        double min = 0;
        double max = array[array.length - 1];

        while (Math.abs(max - min) >= 1e-3) {
            double mid = min + (max - min) / 2.0;
            int result = 0;
            for (Integer value : array) {
                result += value / mid;
            }
            if (result >= m) {
                min = mid;
                res = mid;
            } else {
                max = mid;
            }
        }

        return res;
    }
}
