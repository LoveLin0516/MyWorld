package com.example.myworld.aoffer;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 */
class Test_No40_MinK {

    public static void main(String[] args) {
        int[] input = {3, 2, 1};
        new Solution().getLeastNumbers(input, 2);
    }

    static class Solution {

        int[] result;

        public int[] getLeastNumbers(int[] arr, int k) {
            sort(arr, k, 0, arr.length - 1);
            result = Arrays.copyOf(arr, k);
            return result;
        }

        private void sort(int[] arr, int k, int left, int right) {
            int i = left;
            int j = right;
            int key = arr[i];
            if (i >= j) return;
            while (i < j) {
                while (i < j && arr[j] >= key) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }

            arr[i] = key;
            if (i == k - 1) {
                //错误做法？？？？？？？？
//                result = Arrays.copyOf(arr, k);
                return;
            } else {
                if (i > k - 1) {
                    sort(arr, k, left, i - 1);
                } else if (i < k - 1) {
                    sort(arr, k, i + 1, right);
                }
            }
        }
    }


}
