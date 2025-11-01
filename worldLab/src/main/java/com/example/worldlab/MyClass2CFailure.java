package com.example.worldlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyClass2CFailure {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Arrays.sort(new int[]{1, 2, 3});


        Integer[] array = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(array);

//        int[] array3 = new int[]{1,2,3};
//        List<Integer> list3 = Arrays.asList(array);

//        List<Integer> list2 = new ArrayList<>();
//        int[] array2 =  list2.toArray();
    }

    /**
     * <p>
     * * 输入: [7,1,5,3,6,4]
     * * <p>
     * * 输出: 5
     * * <p>
     * * [7,6,4,3,1]
     * * <p>
     * * 输出: 0
     */
    public static int gupiao(int[] array) {
        int minValue = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            minValue = Math.min(minValue, array[i]);
            result = Math.max(result, array[i] - minValue);
        }
        return result;

    }

    public void gupiao2(int[] array) {

    }


}