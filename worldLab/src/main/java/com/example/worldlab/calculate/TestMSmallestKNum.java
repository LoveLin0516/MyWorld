package com.example.myworld.calculate;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/15
 * Description:
 * <p>
 * <p>
 * <p>
 * 用非全排序的方式，找到第K小的数  done
 * <p>
 * - [4，6，3，7，8，10，9，5] 以7为基准
 * - [4，6，3，5，7，8，10，9]   拿a[k]的值和 7比较，看是比7大还是比7小
 * - 类似二分查找法
 * <p>
 * <p>
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
class TestMSmallestKNum {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        int bArray[] = {8, 2, 5, 0, 7, 4, 6, 1};
        int cArray[] = {-1, 5, 2, 0, 10, -3, 0, 8, 7, 4, 6, 1};
        int k = 8;

        cArray = new int[]{3, 2, 1};
        k = 2;

        array = cArray;
        quickSort(array, 0, array.length - 1, k);
        for (Integer aa : array) {
            System.out.println(aa.toString());
        }
        System.out.println("result----2--->" + array[k - 1]);

        int[] array2 = Arrays.copyOf(array, k);

        for (Integer aa : array2) {
            System.out.println("element---->" + aa.toString());
        }
    }

    public static void quickSort(int[] array, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int aim = array[i];

        while (i < j) {
            while (i < j && array[j] >= aim) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < aim) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }

        array[i] = aim;

        if (i == k - 1) {
            System.out.println("result is ----->" + array[k - 1]);
        }
        if (i > k - 1) {
            quickSort(array, left, i - 1, k);
        } else if (i < k - 1) {
            quickSort(array, i + 1, right, k);
        }

    }
}
