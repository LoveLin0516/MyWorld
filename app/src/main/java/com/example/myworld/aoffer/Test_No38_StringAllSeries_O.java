package com.example.myworld.aoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Test_No38_StringAllSeries_O {

    public static void main(String[] args) {
        new Solution().permutation("abc");
    }

    static class Solution {
        public String[] permutation(String s) {
            List<List<Character>> res = new ArrayList<>();

            List<Character> originList = new ArrayList<>();
            for (Character cc : s.toCharArray()) {
                originList.add(cc);
            }
            sort(originList, 0, res);


            String[] array = new String[res.size()];
            int index = 0;
            for (List<Character> tempList : res) {
                StringBuilder sb = new StringBuilder();
                for (Character ss : tempList) {
                    sb.append(ss);
                }
                array[index] = sb.toString();
                index++;
            }
            return array;
        }

        public void sort(List<Character> originList, int beginIndex,
                         List<List<Character>> res) {

            if (beginIndex == originList.size()) {
                if (!res.contains(originList)) {
                    res.add(new ArrayList<>(originList));
                }
                return;
            }
            for (int i = beginIndex; i < originList.size(); i++) {
                Collections.swap(originList, i, beginIndex);
                sort(originList, beginIndex + 1, res);
                Collections.swap(originList, i, beginIndex);
            }

        }

        /**
         * 一开始写的错误部分
         * Error Error Error Error Error
         * Error Error Error Error Error
         */
        public void sort2(String s, int beginIndex, List<Character> list,
                          List<List<Character>> res) {

            if (beginIndex == s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }
            list.add(s.charAt(beginIndex));
//            sort2(s, ++beginIndex, list, res);
//            char[] array = s.toCharArray();
//            for (int i = beginIndex; i < array.length; i++) {
//               sort2(s, i, list, res);
//               sort2(s, i+1, list, res);
//            }
            list.remove(list.size() - 1);

        }
    }


}
