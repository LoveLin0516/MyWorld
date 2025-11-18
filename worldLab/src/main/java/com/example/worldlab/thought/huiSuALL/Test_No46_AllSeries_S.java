package com.example.myworld.aleetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 46. 全排列
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 */
class Test_No46_AllSeries_OOO {

    public static void main(String[] args) {

    }

    /**
     * 自己摸索着写的
     */
    class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            List<Integer> path = new ArrayList();
            for(Integer integer: nums){
                path.add(integer);
            }
            doSth(nums, result, path, 0);
            return result;
        }

        public void doSth(int[] nums,List<List<Integer>> result,List<Integer> path,int begin ){
            if(begin==nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            //注意这里是begin+1, 唯一的区别
            //注意这里是begin+1, 唯一的区别
            //注意这里是begin+1, 唯一的区别
            for(int i=begin;i< nums.length;i++){
                Collections.swap(path, i, begin);
                doSth(nums, result, path, begin+1);
                Collections.swap(path, i, begin);

            }

        }
    }


    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
//                return;
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }

}
