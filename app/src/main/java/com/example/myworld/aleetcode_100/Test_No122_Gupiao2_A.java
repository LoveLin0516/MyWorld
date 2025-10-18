package com.example.myworld.aleetcode_100;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
 */
class Test_No122_Gupiao2 {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        new Solution().maxProfit(nums);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int result = 0;

            for (int i = 0; i < prices.length - 1; i++) {
                int currentResult = 0;

                int start = i;
                int end = i + 1;
                while (start < prices.length
                        && end < prices.length) {
                    if (prices[end] > prices[start]) {
                        currentResult += prices[end] - prices[start];

                        if (end < prices.length - 1 && prices[end + 1] < prices[end]) {
                            start = end + 1;
                        } else {
                            start = end;
                        }

                        end = start + 1;
                    } else {
                        start = end;
                        end = start + 1;
                    }
                }

                result = Math.max(result, currentResult);

            }
            return result;
        }
    }

    /**
     * 贪心算法
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }




}
