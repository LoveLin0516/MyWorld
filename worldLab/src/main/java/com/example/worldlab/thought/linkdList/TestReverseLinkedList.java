package com.example.myworld.cstructure;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/15
 * Description:
 */
class TestReverseLinkedList {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        ListNode head3 = new ListNode(3, null);
        ListNode head2 = new ListNode(2, head3);

        ListNode head = new ListNode(1, head2);

        ListNode newHead = reverseList(head);

        System.out.println("oldHead value---->" + head.key);
        System.out.println("newHead value---->" + newHead.key);
    }
    // 1——》2-》3——》4-》5->null
    // 1->null 2->3->4_>5->null
    // 2->1->null


    public static ListNode reverseList(ListNode head) {
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

    static class ListNode {
        int key;
        ListNode next;

        public ListNode(int key, ListNode next) {
            this.key = key;
            this.next = next;
        }
    }
}




