package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * <p>
 * 13. 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
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
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 */
class Test_No13_RomaString {

    public static void main(String[] args) {
        String input = "MMDCLXXXVIII";
        int result = new Solution().romanToInt(input);
        System.out.println("result----->" + result);
    }

    static class Solution {
        int[] arrayInteger = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] arrayChar = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"
        };

        public int romanToInt(String input) {
            int count = 1;
            int result = 0;
            for (String singleContent : arrayChar) {
                while (input.startsWith(singleContent)) {
                    input = input.substring(singleContent.length());
                    if (input.startsWith(singleContent)) {
                        count++;
                    } else {
                        int value = getSingleInteger(singleContent);
                        result = result + count * value;
                        count = 1;
                    }
                }
            }


            return result;
        }


        private int getSingleInteger(String value) {
            int current = 0;
            switch (value) {
                case "M":
                    current = 1000;
                    break;
                case "CM":
                    current = 900;
                    break;
                case "D":
                    current = 500;
                    break;
                case "CD":
                    current = 400;
                    break;
                case "C":
                    current = 100;
                    break;
                case "XC":
                    current = 90;
                    break;
                case "L":
                    current = 50;
                    break;
                case "XL":
                    current = 40;
                    break;
                case "X":
                    current = 10;
                    break;
                case "IX":
                    current = 9;
                    break;
                case "V":
                    current = 5;
                    break;
                case "IV":
                    current = 4;
                    break;
                case "I":
                    current = 1;
                    break;
            }
            return current;
        }
    }

    /**
     * ERROR ERROR ERROR ERROR ERROR
     */
    static class Solution2 {
        int[] arrayInteger = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] arrayChar = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"
        };

        public int romanToInt(String input) {
            char[] array = input.toCharArray();
            int result = 0;
            int index = 0;
            int count = 1;
            //没办法解决连个字母一起的问题
            while (index < array.length - 1) {

                if (array[index] == array[index + 1]) {
                    count++;
                } else {
                    char element = array[index];
                    int value = getSingleInteger(String.valueOf(element));
                    result = result + count * value;

                    count = 1;
                }
                index++;
            }

            char element = array[array.length - 1];
            int value = getSingleInteger(String.valueOf(element));
            result = result + count * value;


            return result;
        }


        private int getSingleInteger(String value) {
            int current = 0;
            switch (value) {
                case "M":
                    current = 1000;
                    break;
                case "CM":
                    current = 900;
                    break;
                case "D":
                    current = 500;
                    break;
                case "CD":
                    current = 400;
                    break;
                case "C":
                    current = 100;
                    break;
                case "XC":
                    current = 90;
                    break;
                case "L":
                    current = 50;
                    break;
                case "XL":
                    current = 40;
                    break;
                case "X":
                    current = 10;
                    break;
                case "IX":
                    current = 9;
                    break;
                case "V":
                    current = 5;
                    break;
                case "IV":
                    current = 4;
                    break;
                case "I":
                    current = 1;
                    break;
            }
            return current;
        }
    }
}
