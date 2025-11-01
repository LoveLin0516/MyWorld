package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/5/4
 * Description:
 * <p>
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * <p>
 * 答案见评论区第一条
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/comments/
 */
class Test_No54_SearchTreeKNode {

    public static void main(String[] args) {

    }

    /**
     * 剪枝最优化版
     */
    class Solution {
        int count = 0;
        int result;

        public int kthLargest(TreeNode root, int k) {
            traverse(root, k);
            return result;
        }

        private void traverse(
                TreeNode root, int k) {
            if (root == null) return;

            traverse(root.right, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }

            traverse(root.left, k);
        }
    }

    /**
     * Error Error Error Error Error
     * Error Error Error Error Error
     */
    class Solution2 {
        int count = 0;

        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            traverse(list, root, k);
            return list.get(list.size() - 1);
        }

        private void traverse(List<Integer> list,
                              TreeNode root, int k) {
            if (root == null) return;

            traverse(list, root.right, k);
            count++;
            list.add(root.val);
            if (count == k) return;

            traverse(list, root.left, k);
        }
    }

    /**
     * 非剪枝优化版
     * count未使用，一开始的想法
     */
    class Solution3 {
        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            traverse(list, root, k);
            return list.get(list.size() - k);
        }

        private void traverse(List<Integer> list,
                              TreeNode root, int k) {
            if (root == null) return;
            traverse(list, root.left, k);
            list.add(root.val);
            traverse(list, root.right, k);
        }
    }

    class Solution4 {
        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            traverse(list, root, k);
            return list.get(k - 1);
        }

        private void traverse(List<Integer> list,
                              TreeNode root, int k) {
            if (root == null) return;
            traverse(list, root.right, k);
            list.add(root.val);
            traverse(list, root.left, k);
        }
    }

}
