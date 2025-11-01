package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 12. 整数转罗马数字
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
class Test_No12_RomaNumber {

    public static void main(String[] args) {
        int input = 3688;
        String result = new Solution().intToRoman(input);
        System.out.println("result----->" + result);
    }

    static class Solution {
        int[] array = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < array.length; i++) {
                int m = num / array[i];
                int n = num % array[i];

                if (m > 0) {
                    String current = getSingleChar(array[i]);

                    String another = getSingleChar(m);
                    if (!another.isEmpty() && m != 1) {
                        sb.append(another).append(current);
                    } else {
                        for (int j = 0; j < m; j++) {
                            sb.append(current);
                        }
                    }
                }

                num = n;
            }

            return sb.toString();
        }

        private String getSingleChar(int value) {
            String current = "";
            switch (value) {
                case 1000:
                    current = "M";
                    break;
                case 900:
                    current = "CM";
                    break;
                case 500:
                    current = "D";
                    break;
                case 400:
                    current = "CD";
                    break;
                case 100:
                    current = "C";
                    break;
                case 90:
                    current = "XC";
                    break;
                case 50:
                    current = "L";
                    break;
                case 40:
                    current = "XL";
                    break;
                case 10:
                    current = "X";
                    break;
                case 9:
                    current = "IX";
                    break;
                case 5:
                    current = "V";
                    break;
                case 4:
                    current = "IV";
                    break;
                case 1:
                    current = "I";
                    break;
            }
            return current;
        }
    }
}
