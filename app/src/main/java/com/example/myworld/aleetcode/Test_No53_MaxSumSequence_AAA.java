package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 *
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 94.77%
 * 的用户
 *
 *
 * 内存消耗：
 * 38.3 MB
 * , 在所有 Java 提交中击败了
 * 71.58%
 * 的用户
 */
class Test_No53_MaxSumSequence_AAA {

    public static void main(String[] args) {
        int[] nums = {-3, -2, 0, -1};
        int result = new Solution().maxSubArray(nums);
        System.out.println("result----->" + result);
    }

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

}
