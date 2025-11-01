package com.example.myworld.aleetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
 * <p>
 * 快慢指针详解
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-19-sh-n9ih/
 */
class Test_No19_RemoveNode {

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 先计算链表长度
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     * <p>
     * 空间复杂度：O(1)O(1)。
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode ans = dummy.next;
            return ans;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }

    /**
     * 使用栈的方式
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     * <p>
     * 空间复杂度：O(L)O(L)，其中 LL 是链表的长度。主要为栈的开销。
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<ListNode>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }

    /**
     * 快慢指针
     * 复杂度分析
     * <p>
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     * <p>
     * 空间复杂度：O(1)O(1)。
     */
    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            ListNode ans = dummy.next;
            return ans;
        }


        /**
         * 暂时有问题的写法
         */
        public ListNode removeNthFromEnd3(ListNode head, int n) {

            ListNode cur  = head;
            int length = 0;
            while(cur!=null){
                cur = cur.next;
                length++;
            }

            ListNode temp =head;
            for(int i=0; i<length-n-1;++i){
                temp = temp.next;
            }
            ListNode removeNode =temp.next;
            ListNode next = removeNode.next;
            temp.next = next;
            return head;
        }
    }

    /**
     * 使用递归的方式
     */
//    class Solution {
//        public:
//        int cur=0;
//        ListNode* removeNthFromEnd(ListNode* head, int n) {
//            if(!head) return NULL;
//            head->next = removeNthFromEnd(head->next,n);
//            cur++;
//            if(n==cur) return head->next;
//            return head;
//        }
//    };




}
