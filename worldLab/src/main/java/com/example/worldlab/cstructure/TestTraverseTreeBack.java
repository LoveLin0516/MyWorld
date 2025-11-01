package com.example.myworld.cstructure;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.LinkedList;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/8
 * Description: back traverse
 *
 * 145. 二叉树的后序遍历
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
class TestTraverseTreeBack {

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

        TreeNode node = deserialize(result);
        System.out.println("detraverse-node--->" + node.val);
        System.out.println("detraverse-node.left--->" + node.left.val);
        System.out.println("detraverse-node.right--->" + node.right);
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
        serialize(root.right, sb);

        /****** 后序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        // 从后往前取出元素
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 先构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
