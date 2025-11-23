package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * 找出数组中最大的两个数并求和
 *
 * https://chat.deepseek.com/a/chat/s/0c2437f8-d849-4a59-b9a6-e5d3cb8104d8
 *
 *
 */
class Test_No_find2BigNumSum_A {

    public static void main(String[] args) {


    }

    /**
     * 自己简单手写的
     */
    public static int findMaxTwoSum2(int[] nums) {

        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int num: nums){
            if(num>max1){
                max1=num;
                max2=max1;
            } else if(num>max2){
                max2=num;
            }
        }
        return max1+max2;
    }

    public static class MaxTwoSum {
        public static int findMaxTwoSum(int[] nums) {
            if (nums == null || nums.length < 2) {
                throw new IllegalArgumentException("数组至少需要包含2个元素");
            }

            // 初始化最大的两个数
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;

            // 一次遍历找到最大的两个数
            for (int num : nums) {
                if (num > max1) {
                    max2 = max1;  // 原来的最大值变成第二大值
                    max1 = num;   // 更新最大值
                } else if (num > max2) {
                    max2 = num;   // 更新第二大值
                }
            }

            System.out.println("最大的两个数: " + max1 + " 和 " + max2);
            return max1 + max2;
        }

    }
}
