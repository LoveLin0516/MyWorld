package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 26. 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
class Test_No26_RemoveSame {

    public static void main(String[] args) {

    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0 || nums.length == 1) {
                return nums.length;
            }

            int j = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    nums[j] = nums[i];
                    j++;
                }

                if (i == nums.length - 2) {
                    nums[j] = nums[i + 1];
                    j++;
                }
            }
            return j;
        }

        /**
         * 官方做法，不太喜欢
         */
        public int removeDuplicates2(int[] nums) {
            if (nums.length == 0) return 0;
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[j]) {
                    j++;
                    nums[j] = nums[i];
                }
            }
            return j + 1;
        }

        public int strStr(String haystack, String needle) {
            if (needle.equals("")) return 0;
            return haystack.indexOf(needle);
        }
    }
}
