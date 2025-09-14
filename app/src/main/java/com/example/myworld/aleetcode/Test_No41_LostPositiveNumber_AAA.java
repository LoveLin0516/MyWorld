package com.example.myworld.aleetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 */
class Test_No41_LostPositiveNumber_AAA {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int result = new Solution().firstMissingPositive(nums);
        System.out.println("result----->" + result);
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) return 1;
            Arrays.sort(nums);
//            Arrays.asList(nums);

            int length = nums.length;
            if (nums[length - 1] <= 0) {
                return 1;
            }

            int result = 1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (result < nums[i]) {
                    return result;
                } else {
                    result++;
                }
            }
            return result;
        }
    }

}
