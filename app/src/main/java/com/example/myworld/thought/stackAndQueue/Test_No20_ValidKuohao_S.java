package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，
 * 判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 *
 * https://leetcode-cn.com/problems/valid-parentheses/comments/
 *
 * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
 *
 *
 *
 *
 */

/**
 * **经典题目**：
 *
 * - **简单**：
 *   - [20. 有效的括号](https://leetcode.com/problems/valid-parentheses/)（栈的经典应用）
 *   - [232. 用栈实现队列](https://leetcode.com/problems/implement-queue-using-stacks/)
 * - **中等**：
 *   - [155. 最小栈](https://leetcode.com/problems/min-stack/)
 *   - [739. 每日温度](https://leetcode.com/problems/daily-temperatures/)（单调栈模板题）
 *   - [503. 下一个更大元素 II](https://leetcode.com/problems/next-greater-element-ii/)（循环数组）
 * - **困难**：
 *   - [239. 滑动窗口最大值](https://leetcode.com/problems/sliding-window-maximum/)（单调队列）
 */
class Test_No20_ValidKuohao {

    public static void main(String[] args) {
        int[] array = {1, 2};
//
//        List<Integer> list = new ArrayList(Arrays.asList(array));
//        System.out.println(list.size());
    }

    /**
     * 评论区第一做法
     * https://leetcode-cn.com/problems/valid-parentheses/comments/
     */
    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }
            while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
                s = s.replace("()", "");
                s = s.replace("{}", "");
                s = s.replace("[]", "");
            }

            return s.isEmpty();
        }
    }

    /**
     * 使用栈实现
     *
     * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
     *
     */
    class Solution2 {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
//            Stack<Character> stack = new Stack();
            //"()[]{}"  ({}[])
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }


}
