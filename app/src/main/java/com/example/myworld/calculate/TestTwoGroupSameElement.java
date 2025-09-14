package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/12
 * Description:
 * 判断两个数组中是否有相同的数字：点击打开链接
 * //https://blog.csdn.net/qq_34840129/article/details/80803894
 *
 * 给定两个已排好序的数组，判断两个数组中是否存在相同的数字？
 */

class TestTwoGroupSameElement {

    static int[] array = new int[10];
    static int[] array1 = {1, 2, 3, 4, 5,7,9};
    static int[] array2 = {6, 7, 8};

    public static void main(String args[]) {
        int index1 = 0;
        int index2 = 0;
        boolean result = false;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                index1++;
            } else if (array1[index1] > array2[index2]) {
                index2++;
            } else {
                result = true;
                break;
            }
        }
        System.out.println("result---->" + result);
    }

}
