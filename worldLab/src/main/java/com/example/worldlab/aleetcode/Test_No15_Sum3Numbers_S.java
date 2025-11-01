package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
 */
class Test_No15_Sum3Numbers_S {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            //排序
            Arrays.sort(nums);
            //双指针
            int len = nums.length;
            for (int i = 0; i < len; ++i) {
                if (nums[i] > 0) return lists;

                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int curr = nums[i];
                int L = i + 1, R = len - 1;
                while (L < R) {
                    int tmp = curr + nums[L] + nums[R];
                    if (tmp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(curr);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        lists.add(list);
                        while (L < R && nums[L + 1] == nums[L]) ++L;
                        while (L < R && nums[R - 1] == nums[R]) --R;
                        ++L;
                        --R;
                    } else if (tmp < 0) {
                        ++L;
                    } else {
                        --R;
                    }
                }
            }
            return lists;
        }
    }


    /**
     * Error Error Error Error Error
     */
    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {

            quickSort(nums, 0, nums.length - 1);

            List<List<Integer>> list = new ArrayList<>();
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int value = nums[left] + nums[right];
                for (int k = left + 1; k < right; k++) {
                    if (value + nums[k] == 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        tempList.add(nums[k]);
                        list.add(tempList);
                    }
                }
            }

            return list;
        }

        private static void quickSort(int[] array, int left, int right) {

        }
    }
}
