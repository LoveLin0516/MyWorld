package com.example.worldlab.cafail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 虾皮三面算法题
 * <p>
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/
 * <p>
 *
 * https://chat.deepseek.com/a/chat/s/f22e5569-9008-4abd-b0ff-f15bb3b89ba5
 */
class Test_No581_findUnsortedSubarray {


    /**
     * 排序法
     */
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // 1. 复制原数组并排序
            int[] sortedNums = nums.clone();
            Arrays.sort(sortedNums);

            // 2. 从左到右找第一个不同的位置，即左边界
            int left = 0;
            while (left < nums.length) {
                if (nums[left] == sortedNums[left]) {
                    left++;
                } else {
                    break;
                }
            }
            // 如果left走到头，说明数组已经有序，直接返回0
            if (left == nums.length) {
                return 0;
            }

            // 3. 从右到左找第一个不同的位置，即右边界
            int right = nums.length - 1;
            while (right >= 0) {
                if (nums[right] == sortedNums[right]) {
                    right--;
                } else {
                    break;
                }
            }

            // 4. 计算子数组长度
            return right - left + 1;
        }
    }

    /**
     * 一次遍历法
     *
     * 从左向右遍历：维护一个遇到的最大值max。如果当前值nums[i]小于这个max，
     * 说明这个位置处于无序部分，更新右边界end。最终end会停留在无序部分最右边的位置。
     *
     * 从右向左遍历：维护一个遇到的最小值min。如果当前值nums[i]大于这个min，
     * 说明这个位置处于无序部分，更新左边界begin。最终begin会停留在无序部分最左边的位置。
     */
    class Solution2 {
        public int findUnsortedSubarray(int[] nums) {
            // 初始化
            int n = nums.length;
            int begin = 0, end = -1; // 如果数组有序，则end-begin+1=0
            int max = nums[0]; // 从左向右遍历时记录最大值
            int min = nums[n - 1]; // 从右向左遍历时记录最小值

            for (int i = 0; i < n; i++) {
                // 从左向右找右边界
                if (nums[i] >= max) {
                    max = nums[i];
                } else {
                    end = i; // 当前元素小于之前的最大值，更新右边界
                }

                // 从右向左找左边界
                int j = n - 1 - i;
                if (nums[j] <= min) {
                    min = nums[j];
                } else {
                    begin = j; // 当前元素大于之后的最小值，更新左边界
                }
            }

            return end - begin + 1;
        }
    }


    /**
     * 自己写的第二版
     * Error Error Error Error Error
     *
     * 1. 逻辑错误
     * 你在内层循环中同时检查条件和更新边界，这会导致逻辑混乱
     *
     * state变量使用不当，在内层循环中被多次赋值，只有最后一次有效
     *
     * 当发现一个元素不满足条件时立即调整边界，但后续元素可能还有更多问题
     *
     *
     */

    class Solution3 {
        public int findUnsortedSubarray(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int minLength = 0;

            int state = 0;
            while (left < right) {

                if (left < 0 || right >= nums.length) {
                    break;
                }

                int i = left + 1;
                int j = right - 1;

                for (int k = i; k < j; k++) {

                    if (k < 0 || k > right) {
                        break;
                    }

                    if (nums[k] > nums[left] && nums[k] < nums[right]) {
                        minLength = Math.min(minLength, right - left + 1);
                        left++;
                        right--;

                    } else if (nums[k] < nums[left]) {
                        state = 2;
                        left--;

                    } else if (nums[k] > nums[right]) {
                        state = 3;
                        right++;

                    }
                }
            }
            minLength = Math.min(minLength, right - left + 1);
            return minLength;
        }
    }

    /**
     * 自己写的第一版demo
     * Error Error Error Error Error
     */
    public int main(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int minLength = 0;

        int state = 0;
        while (left <= right) {
            int i = left + 1;
            int j = right - 1;

            for (int k = i; k < j; k++) {

                if (nums[k] > nums[left] && nums[k] < nums[right]) {
                    state = 1;

                } else if (nums[k] < nums[left]) {
                    state = 2;
                    left--;

                } else if (nums[k] > nums[right]) {
                    state = 3;
                    right++;

                }
            }

            if (state == 1) {
                minLength = Math.min(minLength, right - left + 1);
                left++;
                right--;
            } else if (state == 2) {
                left--;
            } else if (state == 3) {
                right++;
            }

        }
        minLength = Math.min(minLength, right - left + 1);
        return minLength;

    }


}
