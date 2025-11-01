package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 */
class Test_No57_InsertIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6,9}};
        int[] newIntervals = {2, 5};
        new Solution().insert(intervals, newIntervals);
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if ((intervals == null || intervals.length == 0))
                return new int[][]{{newInterval[0], newInterval[1]}};
//            if (intervals.length == 1) return intervals;
//            Arrays.sort(intervals, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0] - o2[0];
//                }
//            });

            List<int[]> resultList = new ArrayList<>();

            //输入
            //[[1,3],[2,6],[8,10],[15,18]]
            //输出
            //[[1,3],[2,6],[8,10],[15,18]]
            //预期结果
            //[[1,6],[8,10],[15,18]]

            boolean flag = true;

            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];

                if (newInterval[0] <= left && flag) {
                    left = newInterval[0];
                    right = newInterval[1];
                    flag = false;
                    i--;
                }

                if (resultList.size() == 0 || resultList.get(resultList.size() - 1)[1] < left) {
                    resultList.add(new int[]{left, right});
                } else {
                    resultList.get(resultList.size() - 1)[1] = Math.max(resultList.get(resultList.size() - 1)[1], right);
                }

                if (flag) {
                    if (i == intervals.length - 1) {
                        int left2 = newInterval[0];
                        int right2 = newInterval[1];

                        if (resultList.size() == 0 || resultList.get(resultList.size() - 1)[1] < left2) {
                            resultList.add(new int[]{left2, right2});
                        } else {
                            resultList.get(resultList.size() - 1)[1] = Math.max(resultList.get(resultList.size() - 1)[1], right2);
                        }
                        flag = false;
                    }
                }

            }

            return resultList.toArray(new int[resultList.size()][]);
        }
    }

}
