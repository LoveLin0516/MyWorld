package com.example.myworld.calculate;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/13
 * Description:
 * 算法题：最长上升子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */



class TestMaxRiseSequence {
    public static void main(String[] args) {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] array2 = {0, 3, 1, 3, 2, 3};
//        int[] array2 = {0, 1, 0, 3, 2, 3};
        int[] array3 = {7, 7, 7, 7, 7, 7, 7};

        System.out.println("result----->" + getMaxLength(array));
        System.out.println("result---2-->" + getMaxLength(array2));
        System.out.println("result---3-->" + getMaxLength(array3));

    }

    /**
     *
     * 自己手写
     */
    public static int getMaxLength3(int[] array) {
        int[] dp= new int[array.length];

        int maxLength=1;
        Arrays.fill(dp, 1);
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                if (array[j]> array[i]){
                    dp[j]= Math.max(dp[j], dp[i]+1);
                }
            }
            maxLength= Math.max(maxLength,dp[j]);
        }
    }


    public static int getMaxLength(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        int maxLength = 1;
        dp[0] = 1;
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }




//    public static int getLength(int[] array) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//
//        int currentValue = array[0];
//        int currentLength = 1;
//
//        int index = 0;
//
//        while (index < array.length - 1) {
//            if (currentValue < array[index + 1]) {
//                currentValue = array[index + 1];
//                currentLength++;
//            }
//            index++;
//        }
//        return currentLength;
//    }
//
//    public static int getMaxRiseLength(int[] array) {
//        int largestLength = 0;
//        for (int i = 0; i < array.length; i++) {
//            int[] newArray = Arrays.copyOfRange(array, i, array.length);
//            int currentLength = getLength(newArray);
//            if (currentLength > largestLength) {
//                largestLength = currentLength;
//            }
//        }
//        return largestLength;
//    }

    static class Solution {
        public static int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }

}
