package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/5/4
 * Description:
 * <p>
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * <p>
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class Test_No68_TreeAncestor_OOO {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/comments/
     */
    class Solution {
        /**
         * 二叉树的最近公共祖先
         * 思路：
         * 三种情况：
         * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
         * 2、p q 都在左子树
         * 3、p q 都在右子树
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                // p q 一个在左，一个在右
                return root;
            }
            if (left != null) {
                // p q 都在左子树
                return left;
            }
            if (right != null) {
                // p q 都在右子树
                return right;
            }
            return null;
        }
    }

    /**
     * 落樱丶Dance
     * （编辑过）2020-04-05
     * 怎么都是那种纯递归题解。。。 没有人写一下剑指offer书上的题解思路吗。。。
     * 就是前序遍历根节点到p和到q的两个路径（注意剪枝）
     * 然后两个路径逐个比对，最后一个相同的节点即为公共节点。
     * <p>
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/comments/
     */


    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //根节点到p节点的路径
            List<TreeNode> path1 = new ArrayList<>();
            //根节点到q节点的路径
            List<TreeNode> path2 = new ArrayList<>();
            getPath(root, p, path1);
            getPath(root, q, path2);

            TreeNode result = null;
            int n = Math.min(path1.size(), path2.size());
            //保留最后一个相等的节点即为公共节点
            for (int i = 0; i < n; i++) {
                if (path1.get(i) == path2.get(i))
                    result = path1.get(i);
            }
            return result;
        }

        //前序遍历搜索节点p或q
        void getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
            if (root == null)
                return;
            path.add(root);
            if (root == node)
                return;
            if (path.get(path.size() - 1) != node) {
                getPath(root.left, node, path);
            }
            if (path.get(path.size() - 1) != node) {
                getPath(root.right, node, path);
            }
            if (path.get(path.size() - 1) != node) {
                path.remove(path.size() - 1);
            }
        }
    }


}
