package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 38. 外观数列
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * <p>
 * https://leetcode-cn.com/problems/count-and-say/solution/xun-huan-he-di-gui-liang-chong-jie-fa-di-oof8/
 */
class Test_No38_DescribeString {

    public static void main(String[] args) {

    }

    /**
     * 循环
     */
    class Solution {
        public String countAndSay(int n) {
            StringBuilder result = new StringBuilder();
            result.append(1);
            for (int i = 1; i < n; i++) {
                // 记录当前行的字符串
                StringBuilder s = new StringBuilder();
                // 记录每个数字的开始索引
                int start = 0;
                for (int j = 1; j < result.length(); j++) {
                    // 当数字发生改变时执行
                    if (result.charAt(j) != result.charAt(start)) {
                        s.append(j - start).append(result.charAt(start));
                        start = j;
                    }
                }
                // 字符串最后一个数字
                s.append(result.length() - start).append(result.charAt(start));
                result = s;
            }
            return result.toString();
        }
    }


    /**
     * 递归
     */
    class Solution2 {
        public String countAndSay(int n) {
            // 递归终止条件
            if (n == 1) {
                return "1";
            }
            // 获取到上一层的字符串
            String s = countAndSay(n - 1);
            StringBuilder result = new StringBuilder();
            // 记录每个数字的开始索引
            int start = 0;
            for (int i = 1; i < s.length(); i++) {
                // 当数字发生改变时执行
                if (s.charAt(i) != s.charAt(start)) {
                    result.append(i - start).append(s.charAt(start));
                    start = i;
                }
            }
            // 字符串最后一个数字
            result.append(s.length() - start).append(s.charAt(start));
            return result.toString();
        }
    }

}
