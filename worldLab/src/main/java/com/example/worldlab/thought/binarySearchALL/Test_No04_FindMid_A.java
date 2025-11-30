package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Test_No04_FindMid_A {

    public static void main(String[] args) {
//        int[] num1 = {1, 3};
//        int[] num2 = {2};
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};

        double result = new Solution().findMedianSortedArrays(num1, num2);
        System.out.println("result---->" + result);

//        true && 5;
//        true && 1 + 1;
        boolean bb = false && 0 + 8 > 6;
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int[] array = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            int index = 0;
            while (i < nums1.length || j < nums2.length) {
                if (i < nums1.length && j < nums2.length) {
                    if (nums1[i] <= nums2[j]) {
                        array[index] = nums1[i];
                        i++;
                    } else {
                        array[index] = nums2[j];
                        j++;
                    }
                } else if (i < nums1.length) {
                    array[index] = nums1[i];
                    i++;
                } else {
                    array[index] = nums2[j];
                    j++;
                }

                index++;
            }

            int length = array.length;
            if (length % 2 != 0) {
                int resultIndex = (length - 1) / 2;
                return array[resultIndex];
            } else {
                return (array[length / 2] + array[length / 2 - 1]) / 2.0;
            }

        }

        /**
         * 最近通过的
         */
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int[] array = new int[nums1.length + nums2.length];
            int i=0;
            int j=0;
            int index=0;
            double result;
            while(i< nums1.length || j<nums2.length){
                if(i< nums1.length && j<nums2.length){
                    if(nums1[i] < nums2[j]){
                        array[index]=nums1[i];
                        i++;
                    }else{
                        array[index]=nums2[j];
                        j++;
                    }
                }else if(i<nums1.length){
                    array[index]= nums1[i];
                    i++;
                }else{
                    array[index] = nums2[j];
                    j++;
                }

                index++;
            }
            int length =array.length;
            int half = length/2;
            if(length%2==0){
                result = (array[half-1] + array[half])/2.0;
            }else{
                result = array[half];
            }
            return result;
        }
    }
}
