package com.example.worldlab.cafail;

import com.example.myworld.aleetcode.ListNode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 * 字节番茄一面
 */
class Test_RotateRight {

    public static void main(String[] args) {


    }

    class Solution3 {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null) {
                return head;
            }
            int n = 1;
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                n++;
            }
            int add = n - k % n;
            if (add == n) {
                return head;
            }
            //这个相当于到底了之后又走了一遍
            iter.next = head;
            while (add-- > 0) {
                iter = iter.next;
            }
            ListNode ret = iter.next;
            iter.next = null;
            return ret;
        }
    }

    /**
     * 自己实现的向右移动，验证通过222
     * 优化版本，少一次遍历
     */
    class Solution222 {
        public ListNode rotateRight(ListNode head, int k) {

            int length=1;

            ListNode last =head;
            while(last.next!=null){
                last= last.next;
                length++;
            }

            k= k% length;
            if(k==0){
                return head;
            }

            ListNode curHead= head;
            int i=0;
            while(i< length-k-1){
                curHead= curHead.next;
                i++;
            }

            last.next = head;

            ListNode newHead= curHead.next;
            curHead.next=null;

            return newHead;

        }
    }


    /**
     * 自己实现的向右移动，验证通过
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            int length=0;
            ListNode temp = head;
            while(temp!=null){
                temp= temp.next;
                length++;
            }

            int j=0;
            ListNode end=head;
            while(j<length-1){
                end = end.next;
                j++;
            }

            k=k%length;

            if(k==0){
                return head;
            }

            int i=0;
            ListNode curHead = head;
            while(i< length-k-1){
                curHead= curHead.next;
                i++;
            }

            ListNode newHead= curHead.next;
            curHead.next =null;


            end.next = head;
            return newHead;

        }
    }


    /**
     * 这个是向左移动，应该是OK的
     */
    class Solution2 {
        public ListNode rotateLeft(ListNode head, int k) {

            int length=0;
            ListNode temp = head;
            while(temp!=null){
                temp= temp.next;
                length++;
            }

            int j=0;
            ListNode end=head;
            while(j<length-1){
                end = end.next;
                j++;
            }

            k=k%length;

            if(k==0){
                return head;
            }

            int i=0;
            ListNode curHead = head;
            while(i< k-1){
                curHead= curHead.next;
                i++;
            }

            ListNode newHead= curHead.next;
            curHead.next =null;


            //这个点可以优化
            end.next = head;
            return newHead;

        }
    }

    public void doSth() {
        ListNode head2 = head;

        ing length = 0;

        while (head2 != null) {
            head2 = head2.next;
            length++
        }

        ListNode curHead = head

        while (i < n - k % n) {

            curHead = curHead.next

            i++

        }

        ListNode newHead = curHead.next;

        curHead.next = null;
// head2.next =curHead; //这一步还是错了
        return newHead;
    }

}
