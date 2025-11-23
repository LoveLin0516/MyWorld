package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/28
 * Description: 用递归的方式判断字符串是否是回文
 * <p>
 *
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
class Test_No09_125_Huiwen_A {

    public static void main(String[] args) {
        String input = "3214abcddeddcba4123";
        char[] array = input.toCharArray();
        int size = array.length;
        int halfSize = size / 2;

        boolean flag = true;
        for (int i = 0; i < halfSize; i++) {
            if (array[i] != array[size - 1 - i]) {
                flag = false;
                break;
            }
        }
        System.out.println("result---->" + flag);

        System.out.println("handleRecursion---->" + handleRecursion(array, 0));
        System.out.println("handleRecursion2---->" + handleRecursion2(array, 0, array.length - 1));
        System.out.println("handleRecursion3---->" + handleRecursion3(array, 0, array.length - 1));

        System.out.println("handleLoop---->" + handleLoop(array));
    }

    private static boolean handleRecursion(char[] array, int index) {
        int size = array.length;
        if (index < size / 2) {
            return handleRecursion(array, index + 1)
                    && array[index] == array[size - 1 - index];
        }
        return true;
    }

    private static boolean handleRecursion2(char[] array, int left, int right) {
        if (left > right) {
            return true;
        }
        return handleRecursion2(array, left + 1, right - 1)
                && array[left] == array[right];
    }

    private static boolean handleRecursion3(char[] array, int left, int right) {
        if (!isWord(array[left]) && !isDigital(array[left])) {
            left++;
        }

        if (!isWord(array[right]) && !isDigital(array[right])) {
            right--;
        }

        if (left > right) {
            return true;
        }

        return handleRecursion3(array, left + 1, right - 1)
                && array[left] == array[right];
    }

    private static boolean isDigital(char content) {
        return true;
    }

    private static boolean isWord(char content) {
        return true;
    }

    private static boolean handleLoop(char[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !isDigital(array[left]) && !isWord(array[left])) {
                left++;
            }
            while (left < right && !isDigital(array[right]) && !isWord(array[right])) {
                right--;
            }
            //大小写不管
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
