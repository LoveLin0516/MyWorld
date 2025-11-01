package com.example.myworld.aleetcode_100;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 *
 * <p>
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * <p>
 * <p>
 * 内存消耗：
 * 38.6 MB
 * , 在所有 Java 提交中击败了
 * 17.99%
 * 的用户
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
 */
class Test_No104_TreeMaxHeight_A {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);

        TreeNode treeNode3 = new TreeNode(2, treeNode1, null);
        TreeNode treeNode4 = new TreeNode(3, null, treeNode2);

        TreeNode root = new TreeNode(1, treeNode3, treeNode4);

        int height = new Solution2().maxDepth(root);
        System.out.println("result---->" + height);
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            int subHeight = Math.max(leftHeight, rightHeight);
            return subHeight + 1;
        }
    }

    /**
     * 按层次遍历的正确做法，之前的做法是错误的
     */

    static class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int height = 0;
            while (queue.size() != 0) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                height++;
            }
            return height;
        }
    }

    static class Solution3 {
        public int maxDepth(TreeNode root) {
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
