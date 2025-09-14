package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
class Test_No24_Reverse2Group {

    public static void main(String[] args) {

    }

    /**
     * 还可以使用reverseKGroup(head,2)
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            ListNode a, b;
            a = b = head;

            if (b.next == null) {
                return b;
            }
            b = b.next;

            ListNode newHead = b;
            ListNode newStart = b.next;
            b.next = a;

            a.next = swapPairs(newStart);

            return newHead;
        }
    }


}
