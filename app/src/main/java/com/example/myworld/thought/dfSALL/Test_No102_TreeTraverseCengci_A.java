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
 * 102. 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 *
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 94.77%
 * 的用户
 *
 *
 * 内存消耗：
 * 38.3 MB
 * , 在所有 Java 提交中击败了
 * 96.47%
 * 的用户
 */
class Test_No102_TreeTraverseCengci_A {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

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
                list.add(innerList);
            }

            return list;
        }
    }


}
