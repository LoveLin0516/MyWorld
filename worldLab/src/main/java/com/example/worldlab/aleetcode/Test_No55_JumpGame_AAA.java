package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>          0 1 2 3 4
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>          0 1 2 3 4
 * 输入：nums = [3,2,1,0,4] [0,0,5,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 *
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 *
 *
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.98%
 * 的用户
 * 内存消耗：
 * 39.9 MB
 * , 在所有 Java 提交中击败了
 * 97.67%
 * 的用户
 *
 * 官方题解
 * 贪心算法 贪心算法 贪心算法 贪心算法 贪心算法 贪心算法
 */
class Test_No55_JumpGame_AAA {

    public static void main(String[] args) {
        int[] nums= {2,3,1,1,4};
        boolean result = new Solution().canJump(nums);
        System.out.println("result---->"+result);
    }

    //nums = [3,2,1,0,4]
    //nums = [1,2,0,1]
    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            if (nums.length == 1) return true;

            //[2,3,1,1,4]
            //[3,2,1,0,4]
            int temp = 0;
            boolean flag = false;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] > temp) {
                    flag = true;
                    temp = 0;
                } else {
                    flag = false;
                    temp++;
                }
            }
            return flag;
        }
    }


    /**
     * 官方做法
     * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
     */
    public static class Solution2 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


}
