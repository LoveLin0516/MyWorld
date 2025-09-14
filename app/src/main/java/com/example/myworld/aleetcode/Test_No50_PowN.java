package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * <p>
 * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 */
class Test_No50_PowN {

    public static void main(String[] args) {
        double result = new Solution2().myPow(2.0000, 3);
        System.out.println("result----->" + result);
    }

    /**
     * 使用递归
     */
    class Solution {
        public double myPow(double x, int n) {
            double result = 1;
            if (n >= 0) {
                result = myPowInternal(x, n);
            } else {
                result = myPowInternal(x, Math.abs(n));
                result = 1 / result;
            }
            return result;
        }

        public double myPowInternal(double x, int n) {
            double result;
            if (x == 0) return 0;
            if (n == 0) return 1;
            if (n == 1) return x;

            double y = myPowInternal(x, n / 2);

            if (n % 2 == 0) {
                result = y * y;
            } else {
                result = y * y * x;
            }
            return result;
        }
    }


    /**
     * 使用循环
     */
    static class Solution2 {
        public double myPow(double x, int n) {
            long N = n;
            double result = 1;
            if (N >= 0) {
                result = myPowInternal(x, N);
            } else {
                result = myPowInternal(x, Math.abs(N));
                result = 1.0 / result;
            }
            return result;
        }

        public double myPowInternal(double x, long n) {
            double result = 1;
            double temp = x;
            if (x == 0) return 0;
            if (n == 0) return 1;
            if (n == 1) return x;

            while (n > 0) {
                if (n % 2 == 1) {
                    result = result * temp;
                }
                temp = temp * temp;
                n = n / 2;
            }

            return result;
        }
    }


    /**
     * 自己的实现，但是会超时
     */
    class Solution3 {
        public double myPow(double x, int n) {
            double result = 1;
            if (n >= 0) {
                for (int i = 0; i < n; i++) {
                    result = result * x;
                }
            } else {
                int count = Math.abs(n);
                for (int i = 0; i < count; i++) {
                    result = result * x;
                }

                result = 1.0 / result;
            }

            return result;
        }
    }


    /**
     * 使用循环
     * <p>
     * Error Error Error Error Error
     */
    class Solution4 {
        public double myPow(double x, int n) {
            double result = 1;
            if (n >= 0) {
                result = myPowInternal(x, n);
            } else {
                result = myPowInternal(x, Math.abs(n));
                result = 1 / result;
            }
            return result;
        }

        public double myPowInternal(double x, int n) {
            double result = 0;
            if (x == 0) return 0;
            if (n == 0) return 1;
            if (n == 1) return x;

            while (n / 2 > 0) {

                for (int i = 0; i < n / 2; i++) {
                    result = result * x;
                }
                double y = myPowInternal(x, n / 2);
                if (n % 2 == 0) {
                    result = y * y;
                } else {
                    result = y * y * x;
                }
                n = n / 2;
            }

            return result;
        }
    }

}
