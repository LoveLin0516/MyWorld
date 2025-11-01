package com.example.myworld.aleetcode_100;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 *
 *
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.80%
 * 的用户
 *
 *
 * 内存消耗：
 * 58.3 MB
 * , 在所有 Java 提交中击败了
 * 76.75%
 * 的用户
 */
class Test_No111_TreeMinHeight_A {

    public static void main(String[] args) {

    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int height = 0;
            while (queue.size() != 0) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.peek();
                    if (node.left == null && node.right == null) {
                        queue.poll();
                        height++;
                        return height;
                    } else {
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                        queue.poll();
                    }
                    size--;
                }
                height++;
            }
            return height;


        }
    }


}
