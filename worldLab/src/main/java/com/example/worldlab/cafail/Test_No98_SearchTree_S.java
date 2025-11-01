package com.example.myworld.cafail;

import com.example.myworld.cstructure.bean.TreeNode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 *  虎牙二面算法题
 */
class Test_No98_SearchTree {

    public static void main(String[] args) {

    }

    /**
     * 评论区
     * https://leetcode-cn.com/problems/validate-binary-search-tree/comments/
     *
     */
    class Solution {
        double last = -Double.MAX_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (isValidBST(root.left)) {
                if (last < root.val) {
                    last = root.val;
                    return isValidBST(root.right);
                }
            }
            return false;
        }

        // 使用递归检查BST的有效性
        public boolean isValidBST2(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        // validate方法的参数包括当前节点和当前节点可以拥有的值的范围
        private boolean validate(TreeNode node, long lower, long upper) {
            // 如果节点为空，返回true，因为空树是有效的BST
            if (node == null) {
                return true;
            }
            // 检查当前节点的值是否在允许的范围内
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            // 递归检查左子树和右子树
            return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
        }
    }


}
