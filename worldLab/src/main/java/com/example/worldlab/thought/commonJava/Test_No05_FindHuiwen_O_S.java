package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 * 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */
class Test_No05_FindHuiwen_O_S {

    public static void main(String[] args) {
        String input = "babad";
    }


    /**
     * 暂未找到是哪里的解法
     */
    class Solution {

        /**
         * 选这个动态规划，作为解法
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            String ans = "";
            for (int l = 0; l < n; ++l) {
                for (int i = 0; i + l < n; ++i) {
                    int j = i + l;
                    if (l == 0) {
                        dp[i][j] = true;
                    } else if (l == 1) {
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    } else {
                        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                    }
                    if (dp[i][j] && l + 1 > ans.length()) {
                        ans = s.substring(i, i + l + 1);
                    }
                }
            }
            return ans;
        }

        

        // 中心扩散法
        public String longestPalindrome2(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            char[] charArray = s.toCharArray();

            for (int i = 0; i < len - 1; i++) {
                int oddLen = expandAroundCenter(charArray, i, i);
                int evenLen = expandAroundCenter(charArray, i, i + 1);
                int curMaxLen = Math.max(oddLen, evenLen);

                if (curMaxLen > maxLen) {
                    maxLen = curMaxLen;
                    // 这一步要在纸上画图发现规律
                    begin = i - (maxLen - 1) / 2;
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        /**
         * @param charArray 原始字符串的字符数组
         * @param left    起始左边界（可以取到）
         * @param right    起始右边界（可以取到）
         * @return 回文串的长度
         */
        private int expandAroundCenter(char[] charArray, int left, int right) {
            // 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
            // 当 right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
            int len = charArray.length;
            int i = left;
            int j = right;

            while (i >= 0 && j < len) {
                if (charArray[i] == charArray[j]) {
                    i--;
                    j++;
                } else {
                    break;
                }
            }

            // 跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j),
            // 回文串的长度是 j - i + 1 - 2 = j - i - 1
            return j - i - 1;
        }

    }


}
