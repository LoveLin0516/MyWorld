package com.example.myworld.aoffer;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 *
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 *
 */
class Test_No42_MaxSumSequence {

    public static void main(String[] args) {

    }

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int result = nums[0];
            int temp = 0;
            for (Integer integer : nums) {
                temp = temp + integer;
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

}
