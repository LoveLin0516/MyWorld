package com.example.myworld.aleetcode;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import kotlin.Suppress;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 *
 *
 * DeepSeek的解法
 * https://chat.deepseek.com/a/chat/s/c184d657-8d78-4045-8902-868155e83bfe
 */
class Test_No03_StringNoSame_O {
    public static void main(String[] args) {
        String input = "pwwke122w";
//        String input = "asjrgapa";
        int length = new Solution().lengthOfLongestSubstring(input);
        System.out.println("length----->" + length);
    }

    /**
     * 方法一：使用 HashSet
     * String input = "pwwp123";
     */
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Set<Character> window = new HashSet<>();
            int left = 0, right = 0;
            int maxLength = 0;
            int n = s.length();

            while (right < n) {
                char c = s.charAt(right);

                // 如果字符不在窗口中，直接加入
                if (!window.contains(c)) {
                    window.add(c);
                    maxLength = Math.max(maxLength, right - left + 1);
                    right++;
                } else {
                    // 如果字符已存在，移动左指针直到移除重复字符
                    window.remove(s.charAt(left));
                    left++;
                }
            }

            return maxLength;
        }
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     * <p>
     * 选择这个作为最佳答案
     * <p>
     * 方法二：优化版本（使用 HashMap 记录索引）
     */
    String input = "pwwpew";

    class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;

        }
    }

//    start =0;
//    end =4;
//    ans =5;
//
//    start =1;
//    end =4;
//
//    start =1;
//    end =6;
//
//    start =6;
//    end =7;


    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     */
//    class Solution2 {
//        public int lengthOfLongestSubstring(String s) {
//            int n = s.length(), ans = 0;
//            Map<Character, Integer> map = new HashMap<>();
//            for (int end = 0, start = 0; end < n; end++) {
//                char alpha = s.charAt(end);
//                if (map.containsKey(alpha)) {
//                    start = Math.max(map.get(alpha), start);
//                }
//                ans = Math.max(ans, end - start + 1);
//                map.put(s.charAt(end), end + 1);
//            }
//            return ans;
//        }
//    }


    /**
     * 自己写的方法，但是提交超时
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int length = 1;
            char[] array = s.toCharArray();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < array.length; j++) {
                result = new StringBuilder();

                for (int i = j; i < array.length; i++) {
                    if (!result.toString().contains(String.valueOf(array[i]))) {
                        result.append(array[i]);
                        length = Math.max(length, result.length());
                    } else {
                        result = new StringBuilder().append(array[i]);
                    }
                }
            }


            return length;
        }
    }
}


