package com.example.myworld.cstructure;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/8
 * Description: mid traverse
 *
 *  94. 二叉树的中序遍历
 *
 *  输入：root = [1,null,2,3]
 *  输出：[1,3,2]
 *
 *  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */


class TestTraverseTreeMid {

    public static final String SEP = ",";
    public static final String NULL = "#";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = root;

        String result = serialize(root2);
        System.out.println("traverse---->" + result);

//        TreeNode node = deserialize(result);
//        System.out.println("detraverse-node--->"+node.val);
//        System.out.println("detraverse-node.left--->"+node.left.val);
//        System.out.println("detraverse-node.right--->"+node.right);
    }


    /* 主函数，将二叉树序列化为字符串 */
    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        /****** 中序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/
        serialize(root.right, sb);
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

    /**
     * 可以运行得到结果，但是不推荐这种方式
     */
    class Solution2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal2(root, list);
            return list;
        }

        public List<Integer> inorderTraversal2(TreeNode root, List<Integer> list) {
            if (root == null) return new ArrayList<>();
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
            return list;
        }
    }

    /**
     * Error Error Error Error Error
     */
    class Solution3 {
        List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
            return list;
        }
    }


}
