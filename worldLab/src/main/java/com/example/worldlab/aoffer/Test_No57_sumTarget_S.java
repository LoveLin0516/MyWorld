package com.example.myworld.aoffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by zhuqianglong@bigo.sg on 2021/5/4
 * Description:
 * <p>
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
class Test_No57_sumTarget_S {

    public static void main(String[] args) {

        List<List<Integer>> result = getResult(15);
        String stringResult = Arrays.deepToString(result.toArray());
        System.out.println("stringResult---->" + stringResult);

    }

    /**
     *
     * 2025 0919 手写
     */
    public static List<List<Integer>> getResult(int target) {

        int[] aa = new int[]{};
        int[] bb = new int[10];

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i < target; i++) {
            int tempResult = 0;
            List<Integer> tempList = new ArrayList<>();

            int j = i;
            while (j< target && tempResult < target) {
                tempList.add(j);
                tempResult = tempResult + j;
                if (tempResult > target) {
                    tempList.clear();
                    break;
                } else if (tempResult == target) {
                    result.add(tempList);
                    break;
                } else {
                    j++;
                }
            }
        }
        return result;
    }


    static class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> vec = new ArrayList<int[]>();
            for (int l = 1, r = 2; l < r; ) {
                int sum = (l + r) * (r - l + 1) / 2;
                if (sum == target) {
                    int[] res = new int[r - l + 1];
                    for (int i = l; i <= r; ++i) {
                        res[i - l] = i;
                    }
                    vec.add(res);
                    l++;
                } else if (sum < target) {
                    r++;
                } else {
                    l++;
                }
            }
            return vec.toArray(new int[vec.size()][]);
        }
    }


}
