package com.example.myworld.calculate;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/22
 * Description:
 * <p>
 * **3.最少奖品数**
 * 有N个人参加比赛，每个人比赛结束后都会得到一个分数，现在将N个人排成一圈领取奖品，要求：
 * 如果某个人的分数比左右的人稿，那么奖品数一定要比左右人的多。
 * 每个人至少得到一个奖品。
 * 问最少应该准备多少奖品？
 * https://blog.csdn.net/jingnian_destiny/article/details/88880076
 * <p>
 *
 */

/**
 * **3.最少奖品数**
 * 有N个人参加比赛，每个人比赛结束后都会得到一个分数，现在将N个人排成一圈领取奖品，要求：
 * 如果某个人的分数比左右的人稿，那么奖品数一定要比左右人的多。
 * 每个人至少得到一个奖品。
 * 问最少应该准备多少奖品？
 * https://blog.csdn.net/jingnian_destiny/article/details/88880076
 */

/**
 * 分发糖果问题
 * https://zhuanlan.zhihu.com/p/113153440
 *
 *
 * LeetCode相关题目
 *
 * 135. 分发糖果
 * https://leetcode-cn.com/problems/candy/
 */

class TestGetLeastGiftCount {

    public static void main(String[] args) {


        int[] array1 = {1, 2, 87, 87, 87, 2, 1};
        System.out.println("getLeastGiftCount---1--->" + getLeastGiftCount2(array1));
        int[] array2 = {1, 0, 2};
        System.out.println("getLeastGiftCount---2--->" + getLeastGiftCount2(array2));
        int[] array3 = {1, 2, 2};
        System.out.println("getLeastGiftCount---3--->" + getLeastGiftCount2(array3));

        int[] array4 = {3, 4, 5, 5, 3, 2, 1};
        int[] resst4 = {1, 2, 3, 4, 3, 2, 1};
        System.out.println("getLeastGiftCount---4--->" + getLeastGiftCount2(array4));

    }

    /**
     * 要求相同成绩的，糖果数可以不一致
     */
    public static int getLeastGiftCount(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }

        int count = 0;
        for (Integer value : result) {
            count += value;
        }
        return count;
    }

    /**
     * 要求相同成绩的，糖果数一致
     */
    public static int getLeastGiftCount2(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
            if (array[i] == array[i - 1]) {
                result[i] = result[i - 1];
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            if (array[i] == array[i + 1]) {
                result[i] = result[i + 1];
            }
        }

        int count = 0;
        for (Integer value : result) {
            count += value;
        }
        return count;
    }


}
