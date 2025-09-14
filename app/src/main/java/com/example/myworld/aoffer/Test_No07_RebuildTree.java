package com.example.myworld.aoffer;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 剑指 Offer 07. 重建二叉树
 *
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *
 *
 *  https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/comments/
 *
 *  //知识点：
 *
 * 前序遍历列表：第一个元素永远是 【根节点 (root)】
 * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
 * 算法思路：
 *
 * 通过【前序遍历列表】确定【根节点 (root)】
 * 将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
 * 递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
 */
class Test_No07_RebuildTree {

    public static void main(String[] args) {

    }



}
