package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且
 * 有效的括号组合。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 *
 * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 *
 * 评论区题解
 *
 *
 *
 *
 */
class Test_No22_Kuohao_OOO {

    public static void main(String[] args) {
        new Solution().generateParenthesis(2);
    }


    /**
     *
     * 自己手写了下， 验证通过的
     */
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        return build(list, sb.toString(), n,n);
    }

    public List<String> build(List<String> list, String str, int left, int right){
        if(left ==0 && right==0){
            list.add(str);
            return list;
        }
        if(left ==right){
            build(list, str+"(", left-1, right);
        } else if(left < right){
            if(left>0){
                build(list, str+"(", left-1, right);
            }
            build(list, str+")", left, right-1);
        }
        return list;
    }


    /**
     *  评论区题解
     */
    static class Solution {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if(n <= 0){
                return res;
            }
            getParenthesis("",n,n);
            return res;
        }

        private void getParenthesis(String str,int left, int right) {
            if(left == 0 && right == 0 ){
                res.add(str);
                return;
            }
            if(left == right){
                //剩余左右括号数相等，下一个只能用左括号
                getParenthesis(str+"(",left-1,right);
            }else if(left < right){
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if(left > 0){
                    getParenthesis(str+"(",left-1,right);
                }
                getParenthesis(str+")",left,right-1);
            }
        }
    }

    /**
     * 官方题解
     */
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }


//    f(1) = 1;
//    f(2) =
}
