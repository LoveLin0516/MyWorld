package com.example.myworld.cafail;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * 求股票最大利润
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示这支定股票第 i 天的价格。你只能选择某一天买入这只股票，并选择在未来的某一天卖出该股票。
 * 例：[8,5,1,6,2,8,6,1,9,4]；这支股票第1天的价格是8，第2天价格是5...第10天价格是4
 * 设计一个算法来计算你所能获取的最大利润。返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 *
 *
 * <p>
 * 输入: [7,1,5,3,6,4]
 * <p>
 * 输出: 5
 * <p>
 * [7,6,4,3,1]
 * <p>
 * 输出: 0
 * <p>
 * <p>
 * 剑指 Offer 63. 股票的最大利润
 * <p>
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * <p>
 * 121. 买卖股票的最佳时机
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
 *
 * 抖音一面算法题
 *
 */
class Test_No121_Gupiao {

    public static void main(String[] args) {

    }

    /**
     * 优化一点
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int minPrice = prices[0];
            int result = 0;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);

                result = Math.max(result, prices[i] - minPrice);
            }

            return result;
        }
    }

    /**
     * kimi 生成的
     * @param prices prices
     * @return return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    /**
     * 原始做法
     */
    class Solution2 {
        public int maxProfit(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int result = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        continue;
                    }
                    int temp = nums[j] - nums[i];
                    result = Math.max(result, temp);
                }
            }

            return result;
        }
    }


}
