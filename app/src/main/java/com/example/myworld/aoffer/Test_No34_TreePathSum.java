package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * <p>
 * 113. 路径总和 II
 * <p>
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 *
 *
 * 精选答案：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
 */
class Test_No34_TreePathSum {

    public static void main(String[] args) {

    }

    /**
     * 提交通过
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            sort(root, target, list, res);
            return res;
        }

        public void sort(TreeNode root, int target,
                         List<Integer> list, List<List<Integer>> res) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            if (root.left == null && root.right == null) {
                if (list != null && judge(target, list))
                    res.add(new ArrayList<>(list));
            }
            sort(root.left, target, list, res);
            sort(root.right, target, list, res);
            list.remove(list.size() - 1);
        }

        /**
         * 一开始实现的错误版本
         * Error Error Error Error Error
         * Error Error Error Error Error
         */
        public void sort2(TreeNode root, int target,
                          List<Integer> list, List<List<Integer>> res) {
            if (root.left == null && root.right == null) {
                if (list != null && judge(target, list))
                    res.add(new ArrayList<>(list));
                return;
            }
            list.add(root.val);
            sort(root.left, target, list, res);
            sort(root.right, target, list, res);
            list.remove(list.size() - 1);
        }

        public boolean judge(int target,
                             List<Integer> list) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return target == sum;
        }
    }
}
