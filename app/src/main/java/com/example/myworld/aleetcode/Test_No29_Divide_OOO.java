package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 *
 *
 * https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
 *
 * https://leetcode-cn.com/problems/divide-two-integers/solution/yong-fu-shu-yun-suan-jian-hua-bian-jie-chu-li-by-g/
 */
class Test_No29_Divide_OOO {

    public static void main(String[] args) {
        new Solution2().divide(-2147483648, -1);
    }

//    static class Solution {
//        int divide(int dividend, int divisor) {
//            if(dividend == 0) return 0;
//            if(divisor == 1) return dividend;
//            if(divisor == -1){
//                if(dividend>Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
//                return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
//            }
//            long a = dividend;
//            long b = divisor;
//            int sign = 1;
//            if((a>0&&b<0) || (a<0&&b>0)){
//                sign = -1;
//            }
//            a = a>0?a:-a;
//            b = b>0?b:-b;
//            long res = div(a,b);
//            if(sign>0)return res>Integer.MAX_VALUE?Integer.MAX_VALUE:res;
//            return -res;
//        }
//        int div(long a, long b){  // 似乎精髓和难点就在于下面这几句
//            if(a<b) return 0;
//            long count = 1;
//            long tb = b; // 在后面的代码中不更新b
//            while((tb+tb)<=a){
//                count = count + count; // 最小解翻倍
//                tb = tb+tb; // 当前测试的值也翻倍
//            }
//            return count + div(a-tb,b);
//        }
//
//    }

    /**
     * 正确运行但是超时
     */
    static class Solution2 {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) return 0;
            if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
            if (dividend == -2147483648 && divisor == 1) return -2147483648;
            boolean flag = false;
            if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
                flag = true;
            }
            int count = 0;
            int addResult = 0;

            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            while (addResult < dividend) {
                count++;
                addResult += divisor;
            }

            int result = 0;
            try {
                result = count;
                if (addResult > dividend) {
                    result = count - 1;
                }

                if (flag) {
                    result = -result;
                }
            } catch (Exception ex) {
                result = Integer.MAX_VALUE;
            }


            return result;
        }
    }

    /**
     * https://leetcode-cn.com/problems/divide-two-integers/solution/yong-fu-shu-yun-suan-jian-hua-bian-jie-chu-li-by-g/
     */
    static class Solution3 {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1)
                return Integer.MAX_VALUE;

            boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
            int result = 0;
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            while (dividend <= divisor) {
                int temp = divisor;
                int c = 1;
                while (dividend - temp <= temp) {
                    temp = temp << 1;
                    c = c << 1;
                }
                dividend -= temp;
                result += c;
            }
            return k ? result : -result;
        }
    }
}
