package com.example.myworld.cstructure;

import android.util.Pair;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/13
 * Description: 单向链表是否有环及环长
 *
 * 单链表是否有环，求环起点，环长等，以及链表总长等
 * https://blog.csdn.net/suibianshen2012/article/details/52032138
 */
class TestLoopLinkedList {

    public class LinkedListContainsLoop {
        class ListNode {
            ListNode next;
        }

        /**
         * @param head head
         * @return 链表是否有环，及环长
         */
        boolean isLinkedListContainsLoop(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slowPtr = head;
            ListNode fastPtr = head;
            int length = 0;
            while (slowPtr.next != null && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                length++;
                if (slowPtr == fastPtr) {
                    return true;
                }
            }
            System.out.println("length----->" + length);
            return false;
        }

        /**
         * 获取环的起点，及头结点到环起点的距离
         * 及链表总长
         */
        ListNode getLoopStartNode(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slowPtr = head;
            ListNode fastPtr = head;
            int loopLength = 0;
            while (slowPtr.next != null && fastPtr.next != null
                    && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                loopLength++;
                if (slowPtr == fastPtr) {
                    break;
                }
            }
            System.out.println("length----->" + loopLength);

            ListNode thirdNode = head;
            int singleLength = 0;
            while (thirdNode.next != null && fastPtr != null) {
                thirdNode = thirdNode.next;
                fastPtr = fastPtr.next;
                singleLength++;
                if (thirdNode == fastPtr) {
                    break;
                }
            }

            System.out.println("totalLength----->" + (loopLength + singleLength));
            return thirdNode;
        }

        Pair<Boolean, Integer> isLinkedListContainsLoop2(ListNode head) {
            if (head == null) {
                return new Pair<>(false, 0);
            }
            boolean flag = false;

            ListNode slowPtr = head;
            ListNode fastPtr = head;
            int loopLength = 0;
            while (slowPtr.next != null && fastPtr.next != null
                    && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                loopLength++;
                if (slowPtr == fastPtr) {
                    flag = true;
                    break;
                }
            }
            System.out.println("length----->" + loopLength);
            return new Pair<>(flag, loopLength);
        }
    }
}
