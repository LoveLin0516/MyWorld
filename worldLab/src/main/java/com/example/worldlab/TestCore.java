package com.example.worldlab;



public class TestCore {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
    public ListNode reverseList(ListNode a) {
        ListNode cur = a;
        ListNode pre =null;
        while(cur!=null){
            ListNode temp= cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int aim= array[i];

        while(i<j){
            while(i<j && array[j]>aim){
                j--;
            }
            if(i<j){
                array[i]= array[j];
                i++;
            }

            while(i<j && array[i]<aim){
                i++;
            }
            if(i<j){
                array[j]= array[i];
                j--;
            }
        }

        array[i]= aim;
        quickSort(array, left, i-1);
        quickSort(array, i+1, right);
    }

}
