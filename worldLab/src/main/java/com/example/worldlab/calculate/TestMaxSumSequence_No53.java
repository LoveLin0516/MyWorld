package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/12
 * Description:
 * 判断一个数组中最大子序列的和（数组中存在负数），
 * 例如数组[1,2,-1,4,5]的最大子序列就是它本身，和为1。
 * https://blog.csdn.net/qq_34840129/article/details/80810568
 * <p>
 *
 *
 * 53. 最大子序和
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * <p>
 * [1,2,3,4,5,-5,-6,1000]
 * [1,2,3,-3,-2,-2,3,4]
 * 注意这里的子序列是连续子序列
 * 注意这里的子序列是连续子序列
 * 注意这里的子序列是连续子序列
 * 动态规划
 */
class TestMaxSumSequence_No53 {
    //    static int[] array = {1, 2, 3, 4, 5, -5, -6, 20};
//    static int[] array = {1, 2, 3, -2, -3, 1, 3, 4};
    static int[] array = {1, 2, 3, -3, -2, -2, 3, 4};
//    static int[] array = {1, 2, -1, 4, 5};


    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int result = nums[0];
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp = temp + nums[i];
                if (temp > result) {
                    result = temp;
                }
                if (temp < 0) {
                    temp = 0;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        //这样有问题
//        int result = 0;
//        int temp = 0;
//        for (Integer value : array) {
//            temp += value;
//            if (temp >= result) {
//                result = temp;
//            } else if (temp < 0) {
//                temp = 0;
//            }
//        }
//        System.out.println("result------>" + result);

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new Solution().maxSubArray(nums);
        System.out.println("result----->" + result);
    }

    /**
     * 错误做法
     * Error Error Error Error Error Error
     */
    public static void main1(String[] args) {
        int result = 0;
        int temp = 0;
        for (Integer value : array) {
            temp += value;
            if (temp >= 0) {
                result = temp;
            } else {
                temp = 0;
            }
        }
        System.out.println("result------>" + result);
    }

}
