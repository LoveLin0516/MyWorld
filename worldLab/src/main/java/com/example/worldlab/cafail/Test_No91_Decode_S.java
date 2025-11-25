package com.example.myworld.cafail;

import com.example.myworld.cstructure.bean.TreeNode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * "1" -> 'A'
 *
 * "2" -> 'B'
 *
 * ...
 *
 * "25" -> 'Y'
 *
 * "26" -> 'Z'
 *
 * 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
 *
 * 例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1, 1, 10, 6)
 * "KJF" ，将消息分组为 (11, 10, 6)
 * 消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
 * 注意，可能存在无法解码的字符串。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 *
 *
 *
 * JD 一面面试题
 */
class Test_No91_Decode_S {

    public static void main(String[] args) {

    }

    /**
     上楼梯的复杂版？
     如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
     1.一位数决定一个字母
     2.两位数决定一个字母
     就相当于dp(i) = dp[i-1] + dp[i-2];
     如果不符合条件，又有两种情况
     1.当前数字是0：
     不好意思，这阶楼梯不能单独走，
     dp[i] = dp[i-2]
     2.当前数字不是0
     不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
     dp[i] = dp[i-1];

     */

    /**
     *
     * 例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1, 1, 10, 6)
     * "KJF" ，将消息分组为 (11, 10, 6)
     *
     */
    public int numDecodings2(String s) {
        final int length = s.length();
        if(length == 0) return 0;
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[length+1];
        dp[0] = 1;

        for(int i=0;i<length;i++){
            dp[i+1] = s.charAt(i)=='0'? 0 : dp[i];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[length];
    }

    /**
     *
     * 例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1, 1, 10, 6)
     * "KJF" ，将消息分组为 (11, 10, 6)
     *
     * 用这个
     * 用这个
     * 用这个
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int size = s.length();
        int[] dp = new int[size+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= size; i++) {
            char lastChar = s.charAt(i-2), curChar = s.charAt(i-1);
            if (lastChar == '1' || lastChar == '2' && curChar <= '6') {
                dp[i] += dp[i-2];
            }
            if (curChar != '0') {
                dp[i] += dp[i-1];
            }
        }
        return dp[size];
    }

}
