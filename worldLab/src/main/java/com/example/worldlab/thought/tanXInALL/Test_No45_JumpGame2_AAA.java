package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 *
 * 内存消耗：
 * 35.7 MB
 * , 在所有 Java 提交中击败了
 * 91.47%
 * 的用户
 *
 * 官方题解
 * 贪心算法 贪心算法 贪心算法 贪心算法 贪心算法 贪心算法
 * https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
 */
class Test_No45_JumpGame2_AAA {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        int result = new Solution().jump(nums);
        System.out.println("result----->" + result);
    }

    /**
     * 自己随手写的
     */
    public int jump3(int[] nums) {
        int currentPosition = nums.length-1;
        int step=0;
        while(currentPosition>0){
            for(int i=0; i<currentPosition;i++){
                if(nums[i]+i>= currentPosition){
                    currentPosition= i;
                    step++;
                    break;
                }
            }
        }

    }

    static class Solution {

        /**
         * leetcode.cn/problems/jump-game-ii/solutions/230241/tiao-yue-you-xi-ii-by-leetcode-solution/
         * @param nums nums
         * @return return
         *
         * [2,3,1,1,4]
         *  输出: 2
         */
        public int jump2(int[] nums) {
            int position = nums.length - 1;
            int steps = 0;
            while (position > 0) {
                for (int i = 0; i < position; i++) {
                    if (i + nums[i] >= position) {
                        position = i;
                        steps++;
                        break;
                    }
                }
            }
            return steps;
        }

        public int jump3(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }

        public int jump(int[] nums) {
            if (nums == null || nums.length == 0
                    || nums.length == 1) return 0;

            int result = 0;
            return internalJump(nums, 0, result);
        }

        /**
         * 输入: [2,3,1,1,4]
         * 输出: 2
         */

        public int internalJump(int[] nums, int currentIndex, int result) {
            int length = nums.length;

            if (nums[currentIndex] >= length - 1 - currentIndex) {
                result++;
                return result;
            }

            int temp = 0;
            int index = currentIndex + 1;
            int nextIndex = currentIndex + 1;
            //(index - currentIndex) <= nums[currentIndex] 当前位置最多只能跳这么远
            while (index <= length - 1 && (index - currentIndex) <= nums[currentIndex]) {

                if (nums[index] + (index - currentIndex) >= temp) {
                    temp = nums[index] + (index - currentIndex);
                    nextIndex = index;
                }
                index++;
            }

            result++;

            return internalJump(nums, nextIndex, result);
        }

    }




}
