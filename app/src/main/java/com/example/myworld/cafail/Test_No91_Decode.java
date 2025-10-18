package com.example.myworld.cafail;

import com.example.myworld.cstructure.bean.TreeNode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * JD 一面面试题
 */
class Test_No91_Decode {

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
     *
     * 用这个
     * 用这个
     * 用这个
     */
    public int numDecodings(String s) {
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
            int t = 0;
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
