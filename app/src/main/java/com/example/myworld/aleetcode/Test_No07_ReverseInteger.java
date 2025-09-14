package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 * <p>
 * <p>
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 */
class Test_No07_ReverseInteger {
    public static void main(String[] args) {
        int input = -123453333;
        int result = new Solution().reverse(input);
        System.out.println("result----->" + result);
    }

    static class Solution {
        public int reverse(int x) {
            String content = String.valueOf(x).replace("-", "");
            char[] array = content.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                sb.append(array[i]);
            }

            if (x < 0) {
                sb.insert(0, "-");
            }

            int result = 0;
            try {
                result = Integer.parseInt(sb.toString());
            } catch (Exception e) {
                result = 0;
            }

            return result;
        }
    }

    class Solution2 {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                    return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                    return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }


}
