package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/comments/
 */
class Test_No34_BinarySearch {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] {-1, -1};
            res[0] = binarySearch(nums, target, true);
            res[1] = binarySearch(nums, target, false);
            return res;
        }
        //leftOrRight为true找左边界 false找右边界
        public int binarySearch(int[] nums, int target, boolean leftOrRight) {
            int res = -1;
            int left = 0, right = nums.length - 1, mid;
            while(left <= right) {
                mid = left + (right - left) / 2;
                if(target < nums[mid])
                    right = mid - 1;
                else if(target > nums[mid])
                    left = mid + 1;
                else {
                    res = mid;
                    //处理target == nums[mid]
                    if(leftOrRight)
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            return res;
        }
    }
}
