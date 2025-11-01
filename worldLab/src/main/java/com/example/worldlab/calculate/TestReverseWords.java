package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/12
 * Description:
 * 按单词反转字符串：保持每个单词内的字母顺序不变，只是将单词的顺序反转。例如：
 * <p>
 * 原来的字符串：
 * <p>
 * That is a boy
 * <p>
 * 反转后变为:
 * <p>
 * boy a is That
 * https://blog.csdn.net/qq_34840129/article/details/80815806
 */
class TestReverseWords {

    public static void main(String[] args) {
        String value = "This is a boy Hello world";
        String[] array = value.split(" ");
        for (int index = array.length - 1; index >= 0; index--) {
            System.out.print(array[index] + " ");
        }
    }
}
