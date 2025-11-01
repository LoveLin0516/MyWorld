package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/comments/
 */
class Test_No33_BinarySearch {

    public static void main(String[] args) {

    }

    /**
     * 循环实现
     */
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0, right = len-1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] < nums[right]){
                    if(nums[mid] < target && target <= nums[right])
                        left = mid+1;
                    else
                        right = mid-1;
                }
                else{
                    if(nums[left] <= target && target < nums[mid])
                        right = mid-1;
                    else
                        left = mid+1;
                }
            }
            return -1;
        }
    }

    /**
     * 递归实现
     */
    class Solution2 {
        public int search(int[] nums, int target) {
            return search(nums, 0, nums.length - 1, target);
        }

        private int search(int[] nums, int low, int high, int target) {
            if (low > high)
                return -1;
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < nums[high]) {
                if (nums[mid] < target && target <= nums[high])
                    return search(nums, mid + 1, high, target);
                else
                    return search(nums, low, mid - 1, target);
            } else {
                if (nums[low] <= target && target < nums[mid])
                    return search(nums, low, mid - 1, target);
                else
                    return search(nums, mid + 1, high, target);
            }
        }
    }
}
