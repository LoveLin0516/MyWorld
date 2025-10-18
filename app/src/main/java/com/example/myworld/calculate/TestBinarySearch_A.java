package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/14
 * Description: 二分查找
 */
class TestBinarySearch {

    public static void main(String args[]) {
        int array[] = {2, 5, 8, 9, 12, 15};
        int result = binarySearch(array, 0, array.length - 1, 15);
        System.out.println("result-->" + result);

        int result2 = binarySearch2(array, 0, array.length - 1, 15);
        System.out.println("result-2->" + result2);

        int result3 = binarySearch3(array, 0, array.length - 1, 15);
        System.out.println("result-3->" + result3);

    }

    public static int binarySearch(int array[], int left, int right, int num) {

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

    public static int binarySearch2(int array[], int left, int right, int num) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (num < array[mid]) {
                right = mid - 1;
                return binarySearch2(array, left, right, num);
            } else if (num > array[mid]) {
                left = mid + 1;
                return binarySearch2(array, left, right, num);
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *
     * @param array array
     * @param left left
     * @param right right
     * @param num num
     * @return 11
     * 中间递归过程不使用return，这种是错误的
     * Error Error Error Error Error Error
     */
    public static int binarySearch3(int array[], int left, int right, int num) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (num < array[mid]) {
                right = mid - 1;
                binarySearch2(array, left, right, num);
            } else if (num > array[mid]) {
                left = mid + 1;
                binarySearch2(array, left, right, num);
            } else {
                return mid;
            }
        }
        return -1;
    }

}
