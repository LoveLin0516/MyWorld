package com.example.myworld.cstructure;

import com.example.myworld.cstructure.bean.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/16
 * Description: 按层次遍历，以及递归遍历 二叉树高度

   104. 二叉树的最大深度
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
 */
class TestGetTreeHeight {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = root;

        System.out.println(getHeight(root2));
        System.out.println(getHeightByCengci(root2));
//        System.out.println(getHeight2(root2));
    }

    /**
     * Error Error Error Error Error
     *
     * Error Error Error Error Error
     *
     * Error Error Error Error Error
     *
     * Error Error Error Error Error
     *
     * Error Error Error Error Error
     */
    //按层次遍历二叉树,得到二叉树高度
    public static int getHeightByCengci(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int height = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
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
                height++;
            }
        }

        return height;
    }

    //递归遍历二叉树
    public static int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = getHeight(treeNode.left);
        int rightHeight = getHeight(treeNode.right);
        int subHeight = Math.max(leftHeight, rightHeight);
        return subHeight + 1;
    }

}
