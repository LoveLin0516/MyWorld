package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 *
 */
class Test_No35_BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        new Solution().searchInsert(nums, 2);

    }

    static class Solution {

        public int searchInsert(int[] nums, int target) {
            return binarySearch(nums, target);
        }

        public int binarySearch(int[] nums, int target) {
            int res = nums.length;
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid - 1;
                    res = mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }
            return res;
        }
    }
}
