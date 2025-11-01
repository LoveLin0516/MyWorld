package com.example.myworld.aleetcode;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 94. 二叉树的中序遍历
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 *
 */
class Test_No94_TreeMidTraverse_S {

    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal2(root, list);
            return list;
        }

        public void inorderTraversal2(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorderTraversal2(root.left, list);
            list.add(root.val);
            inorderTraversal2(root.right, list);
        }
    }

}
