package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * https://leetcode.cn/problems/subsets/
 *
 */
class Test_No78_subsets {

    public static void main(String[] args) {

    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        int n;

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (int k = 0; k <= n; k++) {
                backtrack(0, k, new ArrayList<Integer>(), nums);
            }
            return result;
        }

        public void backtrack(int start, int k, ArrayList<Integer> cur, int[] nums) {
            if (k == 0) {
                result.add(new ArrayList<Integer>(cur));
                return;
            }
            for (int i = start; i < n; i++) {
                cur.add(nums[i]);
                backtrack(i + 1, k - 1, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
