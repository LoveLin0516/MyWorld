package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 *
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 *
 *
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 *
 */
class Test_No11_Water {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 25, 24, 5};
        int result = new Solution().maxArea(array);
        System.out.println("result----->" + result);
    }

    /**
     * 双指针
     */
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;


            int result = 0;

            while (left < right) {

                int temp = (right - left) * Math.min(height[left], height[right]);
                result = Math.max(temp, result);

                if (height[left] <= height[right]) {
                    left++;
                } else {
                    right--;
                }

            }

            return result;
        }
    }

    /**
     * Error Error Error Error Error
     */
    static class Solution2 {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int result = (right - left) * Math.min(height[left], height[right]);
            while (left <= right) {

                int newLeft = left + 1;
                int temp = (right - newLeft) * Math.min(height[newLeft], height[right]);
                if (temp > result) {
                    result = temp;
                    left++;
                    continue;
                }

                int newRight = right - 1;
                int temp2 = (newRight - left) * Math.min(height[left], height[newRight]);
                if (temp2 > result) {
                    result = temp2;
                    right--;
                    continue;
                }
                left++;
                right--;
            }

            return result;
        }

        /**
         *
         * 超时超时超时，可能也是错误的了
         */
        public int maxArea3(int[] height) {
            int i=0;
            int j=height.length-1;
            int result =0;
            while(i< j){
                int temp = (j-i)*(Math.min(height[j],height[i]));
                if(temp> result){
                    result= temp;
                }
                if(height[i+1]>=height[i]){
                    i++;
                }else if(height[j-1]>height[j]){
                    j--;
                }

            }
            return result;
        }
    }
}
