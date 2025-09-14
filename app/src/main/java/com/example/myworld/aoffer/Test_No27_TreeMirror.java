package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.Stack;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 剑指 Offer 27. 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 */
class Test_No27_TreeMirror {

    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }
    }

    class Solution2 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;

                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }

            }
            return root;
        }
    }

}
