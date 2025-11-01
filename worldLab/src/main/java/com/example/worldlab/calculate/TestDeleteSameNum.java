package com.example.myworld.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/12
 * Description:
 * 删除一个给定数组中重复的元素：
 * https://blog.csdn.net/qq_34840129/article/details/80811693
 * <p>
 * <p>
 * LeetCode——解决删除数组中重复元素问题三种方式
 * https://blog.csdn.net/Mynewclass/article/details/79805367
 *
 *
 * 删除数组中重复元素
 * https://blog.csdn.net/upupday19/article/details/78134546
 */
class TestDeleteSameNum {
    static int[] array = {1, 1, 2, 3, 5, 444, 4, 44, 6, 7, 2, -1, 4, 5};

    public static void main(String[] args) {
//        HashSet<Integer> hashSet = new HashSet<Integer>();
//        hashSet.add(1);

//        Arrays.copyOf(new int[]{}, 0);
//        List<int[]> tempList = Arrays.asList(array);

//        BubbleSort(array);
//        for (Integer integer : array) {
//            System.out.println("integer--->" + integer);
//        }
//        removeDuplicates2(array);
//        for (Integer integer : array) {
//            System.out.println("integer--->" + integer);
//        }

        List<Integer> integerList = new ArrayList<>();

        // List集合转Set集合的方式有：
        // 一是：Set<Integer> set= new HashSet(list);，
        // 二是：Set<Integer> set = new HashSet<Integer>();set.addAll(list);
//        Set<Integer> numSet = new HashSet<Integer>();
//        numSet.addAll(integerList);
//        numSet.toArray();


        for (int i = 0; i < array.length - 1; i++) {
            if (!integerList.contains(array[i])) {
                integerList.add(array[i]);
            }
        }

        for (Integer integer : integerList) {
            System.out.println("integer--->" + integer);
        }
    }

    public static void BubbleSort(int[] arr) {

        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    //这个是针对排好序的数组
    /**
     * Error Error Error Error Error Error
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        if(nums.length == 0)
        {
            return 0;
        }

        int index = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i-1])
            {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    /**
     * Error Error Error Error Error Error
     */
    public static int[] removeDuplicates2(int[] nums) {
        // write your code here
        if(nums.length == 0)
        {
            return new int[]{};
        }

        int index = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i-1])
            {
                nums[index++] = nums[i];
            }
        }

        return nums;
    }
}
