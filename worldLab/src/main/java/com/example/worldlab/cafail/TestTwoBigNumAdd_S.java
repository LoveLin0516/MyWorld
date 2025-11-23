package com.example.myworld.cafail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/14
 * Description:
 * 两个大整数相加，例如：98765432123456789 + 12345678987654321
 *
 *
 *
 *
 *
 * <p>
 * <p>
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 *
 * 企业微信一面算法题
 */
class TestTwoBigNumAdd {

    public static void main(String args[]) {
        String num1 = "98765432123456789";
        String num2 = "12345678987654321";
        String num = "111111111111111110";

//         num1 = "98765432123456789";
//         num2 = "00000000100654321";
//         num = "98765432224111110";

//        num1 = "10011111";
//        num2 = "22000000011";

        String result = getTwoBigNumAdd(num1, num2);

        System.out.println("result---->" + result);
    }

    /**
     * DeepSeek给的解法， 选这个作为最优解法
     *
     */
    public static String addBigIntegers(String num1, String num2) {
        // 确保num1是较长的字符串
        if (num1.length() < num2.length()) {
            return addBigIntegers(num2, num1);
        }

        StringBuilder result = new StringBuilder();
        int carry = 0; // 进位
        int len1 = num1.length();
        int len2 = num2.length();

        // 从最低位开始相加
        for (int i = 0; i < len1; i++) {
            // 获取num1当前位的数字
            int digit1 = num1.charAt(len1 - 1 - i) - '0';

            // 获取num2当前位的数字（如果num2较短，则视为0）
            int digit2 = i < len2 ? num2.charAt(len2 - 1 - i) - '0' : 0;

            // 当前位的和（包括进位）
            int sum = digit1 + digit2 + carry;

            // 计算当前位的结果和新的进位
            result.append(sum % 10);
            carry = sum / 10;
        }

        // 如果最后还有进位，添加到结果中
        if (carry > 0) {
            result.append(carry);
        }

        // 反转字符串得到正确顺序
        return result.reverse().toString();
    }

    public static String getTwoBigNumAdd(String num1, String num2) {

        char[] charNum1 = num1.toCharArray();
        char[] charNum2 = num2.toCharArray();

        int maxLength = Math.max(charNum1.length, charNum2.length);

        charNum1 = getCharArray(maxLength, charNum1);
        charNum2 = getCharArray(maxLength, charNum2);

        List<Integer> result = new ArrayList<>();

        int forwardValue = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int temp1 = 0;
            int temp2 = 0;
            if (i < charNum1.length) {
                temp1 = Integer.parseInt(String.valueOf(charNum1[i]));
            }
            if (i < charNum2.length) {
                temp2 = Integer.parseInt(String.valueOf(charNum2[i]));
            }

            int currentSum = temp1 + temp2 + forwardValue;
            if (currentSum < 10) {
                result.add(currentSum);
                forwardValue = 0;
            } else {
                result.add((currentSum) % 10);
                forwardValue = (currentSum) / 10; //1
            }

            if (i == 0) {
                if (forwardValue == 1) {
                    result.add(forwardValue);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int index = result.size() - 1; index >= 0; index--) {
            sb.append(result.get(index));
        }
        return sb.toString();
    }

    public static char[] getCharArray(int maxLength, char[] charNum1) {
        char[] temp = new char[maxLength];

        if (charNum1.length < maxLength) {
            for (int i = 0; i < maxLength; i++) {
                if (i < maxLength - charNum1.length) {
                    temp[i] = '0';
                } else {
                    temp[i] = charNum1[charNum1.length - (maxLength - i)];
                }
            }
        } else {
            return charNum1;
        }
        return temp;
    }

    /**
     * 本意是用数组去存放result，需要计算maxLength+1的情况
     * 数组需要移位，有点麻烦
     */
//    public static void main2(String args[]) {
//        String num1 = "98765432123456789";
//        String num2 = "12345678987654321";
//        String num = "111111111111111110";
//
//        char[] charNum1 = num1.toCharArray();
//        char[] charNum2 = num2.toCharArray();
//
//        int maxLength = Math.max(charNum1.length, charNum2.length);
//
//        int[] result = new int[maxLength + 1];
//
////        List<Integer> result = new ArrayList<>();
//
//        int forwardValue = 0;
//
//        for (int i = maxLength - 1; i >= 0; i--) {
//            int temp1 = 0;
//            int temp2 = 0;
//            if (i < charNum1.length) {
//                temp1 = Integer.parseInt(String.valueOf(charNum1[i]));
//            }
//            if (i < charNum2.length) {
//                temp2 = Integer.parseInt(String.valueOf(charNum2[i]));
//            }
//
//            int currentSum = temp1 + temp2 + forwardValue;
//            if (currentSum < 10) {
//                result[i] = currentSum;
//                forwardValue = 0;
//            } else {
//                result[i] = (currentSum) % 10;
//                forwardValue = (currentSum) / 10; //1
//            }
//        }
//    }
}
