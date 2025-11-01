package com.example.myworld.cstructure;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/14
 * Description:
 */
public class TestKGroupReverse {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1 2 3 4 5 6 7 8
    //  a=1 b=4
    // reverse 3 2 1 a=1 b=4
    // a.next= reverseKGroup(b,k)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        int i = 0;
        ListNode a = head;
        ListNode b = head;
        while (i < k) {
            if (b == null) {
                return head;
            }
            b = b.next;
            i++;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 1 2 3 4 5
    // 5 4 3 2 1
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode pre = null;
        while (cur != b) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //reverse 整个 list
    public ListNode reverseList(ListNode a) {
        ListNode cur = a;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 原leetCode记录代码
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (b == null) return head;
                b = b.next;
            }
            // 反转前 k 个元素
            ListNode newHead = reverse(a, b);
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);
            return newHead;
        }

        /** 反转区间 [a, b) 的元素，注意是左闭右开 */
        ListNode reverse(ListNode a, ListNode b) {
            ListNode pre, cur, nxt;
            pre = null; cur = a; nxt = a;
            // while 终止的条件改一下就行了
            while (cur != b) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 返回反转后的头结点
            return pre;
        }

        private ListNode reverseList(ListNode head){
            ListNode pre =null;
            ListNode cur = head;
            while(cur!=null){
                ListNode temp= cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            return pre;
        }
    }

}
