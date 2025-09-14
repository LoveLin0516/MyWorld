package com.example.myworld.aleetcode_100;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 *
 *
 * 内存消耗：
 * 37 MB
 * , 在所有 Java 提交中击败了
 * 5.05%
 * 的用户
 */
class Test_No145_TreeBackTraverse_A {

    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            innerTraversal(root, list);
            return list;
        }

        private List<Integer> innerTraversal(TreeNode root, List<Integer> list) {

            if (root == null) return list;


            innerTraversal(root.left, list);
            innerTraversal(root.right, list);
            list.add(root.val);

            return list;
        }
    }


}
