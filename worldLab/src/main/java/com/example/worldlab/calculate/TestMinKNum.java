package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/15
 * Description:
 * <p>
 *
 * 剑指 Offer 40. 最小的k个数
 *
 *
 * 输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
class TestMinKNum {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        int bArray[] = {8, 2, 5, 0, 7, 4, 6, 1};
        int cArray[] = {-1, 10, -3, 0, 8, 2, 5, 0, 7, 4, 6, 1};
        array = cArray;
        quickSort(array, 0, array.length - 1);
        for (Integer aa : array) {
            System.out.println(aa.toString());
        }
    }

    public static void quickSort(int[] array, int left, int right) {
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

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

        // 找最小的k个数
//        if (i + 1 == k) {
//            return;
//        } else if(i+1>k) {
//            quickSort(array, left, i - 1);
//        } else if(i+1<k){
//            quickSort(array, i + 1, right);
//        }
    }
}
