package com.example.myworld.calculate;

import java.util.Arrays;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/13
 * Description:
 * <p>
 * 一个无序数组中两个数之和等于给定的值
 * https://blog.csdn.net/suibianshen2012/article/details/51923477
 * <p>
 *
 *
 *
 *
 * <p>
 * 数组有序
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers
 * ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * <p>
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 */
class TestTwoNumSum {
    public static void main(String[] args) {
        int[] array = {2, 7, 8, 11, 13, 14, 16, 17};
        int target = 23;

        int[] result = getResult(array, target);
        System.out.println("result---->" + result[0]);
        System.out.println("result---->" + result[1]);

        getResult2(array, target);
    }

    /**
     * 这个是排好序的
     */
    public static int[] getResult(int[] array, int target) {
        int[] result = new int[2];
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex < endIndex) {
            int sum = array[startIndex] + array[endIndex];
            if (sum == target) {
                result[0] = startIndex + 1;
                result[1] = endIndex + 1;
                break;
            } else if (sum < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return result;
    }

    /**
     * 乱序，且要求数组中的数必须是正数
     */
    public static void getResult2(int[] array, int target) {
        boolean[] temp = new boolean[target];
        Arrays.fill(temp, false);
        for (Integer value : array) {
            if (value < target) {
                if (temp[value]) {
                    System.out.println("result2---->" + (target - value));
                    System.out.println("result1---->" + value);
                    break;
                }
//                temp[value] = false;
                temp[target - value] = true;
            }
        }

//        for (Integer value : array) {
//            if (temp[value]) {
//                System.out.println("result1---->" + value);
//                System.out.println("result2---->" + (target - value));
//            }
//        }
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i]) {
//                System.out.println("result1---->" + i);
//                System.out.println("result2---->" + (target - i));
//                break;
//            }
//        }
    }

}
