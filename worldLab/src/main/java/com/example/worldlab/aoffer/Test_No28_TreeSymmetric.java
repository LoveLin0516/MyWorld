package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.Stack;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 */
class Test_No28_TreeSymmetric {

    public static void main(String[] args) {

    }

    /**
     * 还可以按层次遍历去做
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return judge(root.left, root.right);
        }

        private boolean judge(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) {
                return false;
            }

            return left.val == right.val
                    && judge(left.left, right.right)
                    && judge(left.right, right.left);
        }
    }

    /**
     * Error Error Error Error Error
     * Error Error Error Error Error
     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            if (root.left == null && root.right == null) return true;
            if (root.left == null || root.right == null) {
                return false;
            }

            return root.left.val == root.right.val
                    && isSymmetric(root.left)
                    && isSymmetric(root.right);
        }
    }

    /**
     * 来个非递归吧，有点耗时。
     *
     * 思路就是层次遍历，然后对比某一层 是否是镜像。
     *
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/comments/
     */
//    class Solution {
//        public:
//        bool isSymmetric(TreeNode* root) {
//            if(!root){
//                return true;
//            }
//            queue<TreeNode *> que1;
//            que1.push(root);
//            while(!que1.empty()){
//                int size = que1.size();
//                vector<TreeNode *> tmp;
//                while(size > 0){
//                    TreeNode *fronts = que1.front();
//                    que1.pop();
//                    tmp.push_back(fronts->left);
//                    if(fronts->left){
//                        que1.push(fronts->left);
//                    }
//                    tmp.push_back(fronts->right);
//                    if(fronts->right){
//                        que1.push(fronts->right);
//                    }
//                    size --;
//                }
//                int i=0;
//                int j=tmp.size()-1;
//                while(i<j){
//                    if(tmp[i] != nullptr && tmp[j] != nullptr){
//                        if(tmp[i]->val != tmp[j]->val){
//                            return false;
//                        }
//                    }
//                    else if(tmp[i] == nullptr && tmp[j] == nullptr){
//                    }
//                    else{
//                        return false;
//                    }
//                    i++;
//                    j--;
//                }
//            }
//            return true;
//        }
//    };


}
