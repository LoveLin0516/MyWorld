package com.example.worldlab;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class MyClass2Calculate {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = root;
//
//
//        int array[] = {2, 8, 13, 7, 12, 15};
//        int bArray[] = {8, 2, 5, 0, 7, 4, 6, 1};
//        int cArray[] = {-1, 10, -3, 0, 8, 2, 5, 0, 7, 4, 6, 1};
//        for (Integer aa : array) {
//            System.out.println(aa.toString());
//        }

        int[] array4 = {3, 4, 5, 5, 3, 2, 1};
        int[] resst4 = {1, 2, 3, 4, 3, 2, 1};
//        System.out.println("getLeastGiftCount---4--->" + getLeastGiftCount(array4));
//
//        System.out.println("getMaxRiseSequence result--->" + getMaxRiseSequence(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        System.out.println("getMaxSumSequence result--->" + getMaxSumSequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    public static int binarySearch(int array[], int left, int right, int num) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (num < array[mid]) {
            right = mid - 1;
            return binarySearch(array, left, right, num);
        } else if (num > array[mid]) {
            left = mid + 1;
            return binarySearch(array, left, right, num);
        } else {
            return mid;
        }
    }

    public static int binarySearch2(int array[], int left, int right, int num) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (num < array[mid]) {
                right = mid - 1;
            } else if (num > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }

    // 1 1 2 3 5 8 13 21 34
    public static int feibo(int count) {
        if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 2;
        } else {
            return feibo(count - 1) + feibo(count - 2);
        }
    }

    public static int feibo2(int count) {
        int c = 0;
        int a = 1;
        int b = 2;
        if (count == 1) {
            return a;
        } else if (count == 2) {
            return b;
        }
        while (count - 2 >= 0) {
            c = a + b;
            a = b;
            b = c;
            count--;
        }
        return c;
    }

    public static int getLeastGiftCount(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] result = new int[array.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
//            if(array[i]== array[i-1]){
//                result[i] = result[i - 1];
//            }
        }

        for (int j = array.length - 2; j >= 0; j--) {
            if (array[j] > array[j + 1]) {
                result[j] = Math.max(result[j], result[j + 1] + 1);
            }

//            if(array[j]== array[j+1]){
//                result[j] = result[j + 1];
//            }
        }
        int count = 0;
        for (Integer integer : result) {
            count = count + integer;
        }
        return count;
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public static void move(int size, List<Integer> A,
                            List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(size - 1));
            return;
        }
        move(size - 1, A, C, B);

        Integer last = A.remove(size - 1);
        C.add(last);

        move(size - 1, B, A, C);

    }

    /**
     * 示例 1：
     * * 输入：nums = [10,9,2,5,3,7,101,18]
     * * 输出：4
     * * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    public static int getMaxRiseSequence(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int maxNum = array[i];
            int maxLength = 1;
            while (j < array.length) {
                if (array[j] <= maxNum) {
                    j++;
                } else {
                    maxNum = array[j];
                    maxLength = maxLength + 1;
                }
            }
            result = Math.max(result, maxLength);
        }
        return result;
    }

    /**
     * 53. 最大子序和
     * *
     * * 示例 1：
     * *
     * * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * * 输出：6
     * * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public static int getMaxSumSequence(int[] array) {
        int result = array[0];
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sum = sum + array[i];
            if (sum > result) {
                result = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
    //参考原文件
    public static int getMinKNum(int[] array) {
        return 0;
    }

    //参考原文件
    public static int getSmallestKNum(int[] array) {
        return 0;
    }

}