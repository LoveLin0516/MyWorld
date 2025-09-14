package com.example.myworld.calculate;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/22
 * Description:
 * <p>
 * https://blog.csdn.net/jingnian_destiny/article/details/88880076
 */

/**
 * **1.得到的最少硬币数**
 * 货币系统包括1、4、16、64元共计4种硬币，以及面值为1024的纸币。
 * 现在使用1024的纸币购买一件价值为N(0<N<=1024)的商品，问最少收到多少硬币。
 */
class TestGetCoinCount {

    private static int[] coinArray = {1, 4, 16, 64};

    public static void main(String[] args) {
//        int[] array = {0, 1, 2, 3};
//        System.out.println("\n");
//        System.out.println("" + array.length);
//        System.out.println("Hello World!");
//        System.out.println("" + Arrays.toString(array));

//        Test.ExploreManager exploreManager = new Test.ExploreManager();

        int N = 300;
        N = 1024 - N;
        System.out.println("getCoinCount1------>" + getCoinCount1(N));
        System.out.println("getCoinCount2------>" + getCoinCount2(N));


    }

    public static int getCoinCount1(int N) {
        int m1 = N / 64;
        int n1 = N % 64;
        int m2 = n1 / 16;
        int n2 = n1 % 16;
        int m3 = n2 / 4;
        int n3 = n2 % 4;

        int m4 = n3 / 1;
        int n4 = n3 % 1;
        return m1 + m2 + m3 + m4;
    }

    public static int getCoinCount2(int totalCount) {
        int result = 0;
        for (int i = coinArray.length - 1; i > 0; i--) {
            int coinValue = coinArray[i];
            int m = totalCount / coinValue;
            int n = totalCount % coinValue;
            result += m;
            totalCount = n;
        }
        return result;
    }

}
