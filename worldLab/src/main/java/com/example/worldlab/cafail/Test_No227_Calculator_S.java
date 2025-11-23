package com.example.myworld.cafail;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 227. 基本计算器 II
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * <p>
 * <p>
 * 面试题 16.26. 计算器
 * https://leetcode-cn.com/problems/calculator-lcci/
 */
class Test_No227_Calculator {

    public static void main(String[] args) {
        String ss = "3+5/2+2*2+6";
        new Solution().calculate(ss);
    }

    static class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<Integer>();
            char preSign = '+';
            int num = 0;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                    switch (preSign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                    }
                    preSign = s.charAt(i);
                    num = 0;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }

}
