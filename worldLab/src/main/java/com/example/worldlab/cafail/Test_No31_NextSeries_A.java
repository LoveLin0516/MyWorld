package com.example.myworld.cafail;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 字节教育一面算法题
 * 全排列，以及下一个排列
 * 以及 组合这几道题
 *
 * 1 6 7 3 2
 * index =1;
 * --1 7 6 3 2--
 * 1 7 2 3 6
 * --1 7 2 6 3--
 * 1 7 2 6 3
 * --1 7 3 6 2--
 * 1 7 3 2 6
 *
 * 4 5 2 6 3 1
 * index = 2;
 * 4 5 3 6 2 1
 *
 *
 * 4 5 3 1 2 6
 */
class Test_No31_NextSeries {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        new Solution().nextPermutation(nums);
        for (Integer integer : nums) {
            System.out.println("result---->" + integer);
        }
    }

    static class Solution {
        public void nextPermutation(int[] nums) {

            int index = -1;

            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    index = i - 1;
                    break;
                }
            }

            if (index != -1) {
                for (int i = nums.length - 1; i > 0; i--) {
                    if (nums[i] > nums[index]) {
                        swap(nums, i, index);
                        break;
                    }
                }
            }


            reverse(nums, ++index);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int index) {
            int left = index;
            int right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }


//    public class Main {
//        public static void main(String[] args) {
//            //Scanner in = new Scanner(System.in);
//            //int a = in.nextInt();
//            //System.out.println(a);
//            System.out.println("Hello World!");
//        }
//    }


    // int[] array = {1,2,3};
//    public void sort(int[] array) {
//        int num = array[0];
//        for (int i = nums.length - 1; i > 0; i++) {
//            if (nums[i] < num) {
//                i--;
//            }
//
//            swap(array, 0, i);
//
//            reverse(array, i);
//        }
//
//    }


}
