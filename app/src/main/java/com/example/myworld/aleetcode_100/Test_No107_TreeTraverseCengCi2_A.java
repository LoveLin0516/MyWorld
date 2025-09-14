package com.example.myworld.aleetcode_100;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 107. 二叉树的层序遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 *
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.01%
 * 的用户
 *
 *
 * 内存消耗：
 * 38.7 MB
 * , 在所有 Java 提交中击败了
 * 46.20%
 * 的用户
 */
class Test_No107_TreeTraverseCengCi2_A {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> list = new ArrayList<>();
            if (root == null) return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (queue.size() != 0) {

                int size = queue.size();
                List<Integer> innerList = new ArrayList<>();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        innerList.add(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                list.add(0, innerList);
            }

            return list;
        }
    }

}
