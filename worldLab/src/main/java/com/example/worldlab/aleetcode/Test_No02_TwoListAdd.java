package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * 2. 两数相加
 *
 *
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 *
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
class TwoListAdd_No2 {
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode newL1 = reverseList(l1);
        // ListNode newL2 = reverseList(l2);

        ListNode sum = sumTwoList(l1, l2);
        // ListNode result = reverseList(sum);
        return sum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode sumTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode newHead = head;
        int forwardValue = 0;
        while (head1 != null || head2 != null || forwardValue != 0) {
            int num1 = 0;
            int num2 = 0;
            if (head1 != null) {
                num1 = head1.val;
            }
            if (head2 != null) {
                num2 = head2.val;
            }

            int sum = num1 + num2 + forwardValue;
            head.val = sum % 10;
            forwardValue = sum / 10;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }

            if (head1 != null || head2 != null || forwardValue != 0) {
                head.next = new ListNode(0);
                head = head.next;
            }

        }

        return newHead;
    }
}

/**
 * 最早通过LeetCode 通过的代码
 */
class SolutionOrigin {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode newL1 = reverseList(l1);
        // ListNode newL2 = reverseList(l2);

        ListNode sum = sumTwoList(l1, l2);
        // ListNode result = reverseList(sum);
        return sum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode sumTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode newHead = head;
        int forwardValue = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + forwardValue;
            head.val = sum % 10;
            forwardValue = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
            if (head1 != null || head2 != null || forwardValue != 0) {
                head.next = new ListNode(0);
                head = head.next;
            }

        }
        if (head1 == null) {
            while (head2 != null) {
                int sum = head2.val + forwardValue;
                head.val = sum % 10;
                forwardValue = sum / 10;
                head2 = head2.next;
                if (head2 != null || forwardValue != 0) {
                    head.next = new ListNode(0);
                    head = head.next;
                }

            }
        }
        if (head2 == null) {
            while (head1 != null) {
                int sum = head1.val + forwardValue;
                head.val = sum % 10;
                forwardValue = sum / 10;
                head1 = head1.next;

                if (head1 != null || forwardValue != 0) {
                    head.next = new ListNode(0);
                    head = head.next;
                }
            }
        }
        if (forwardValue != 0) {
            head.val = forwardValue;
        }


        return newHead;
    }
}
