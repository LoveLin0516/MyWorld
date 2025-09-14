package com.example.myworld.aleetcode_100;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 *
 * 
 * 内存消耗：
 * 36.7 MB
 * , 在所有 Java 提交中击败了
 * 54.43%
 * 的用户
 */
class Test_No144_TreeFrontTraverse_A {

    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            innerTraversal(root, list);
            return list;
        }

        private List<Integer> innerTraversal(TreeNode root, List<Integer> list) {

            if (root == null) return list;

            list.add(root.val);
            innerTraversal(root.left, list);
            innerTraversal(root.right, list);

            return list;
        }
    }


}
