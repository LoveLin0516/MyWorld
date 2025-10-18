package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 * https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 */
class Test_No56_MergeIntervals {

    public static void main(String[] args) {
//        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input = {{1, 4}, {0, 2}, {3, 5}};
        int[][] result = new Solution2().merge(input);
        System.out.println("result------->" + result.toString());
    }

    //输入：intervals = [[1,3],[2,6],[8,10],[3,7],[5,8],[15,18]]
    // [[1,3],[2,6],[3,7],[5,8],[8,10],[15,18]]


    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //


    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[0][2];
            if (intervals.length == 1) return intervals;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> resultList = new ArrayList<>();

            //输入
            //[[1,3],[2,6],[8,10],[15,18]]
            //输出
            //[[1,3],[2,6],[8,10],[15,18]]
            //预期结果
            //[[1,6],[8,10],[15,18]]


            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (resultList.size() == 0 || resultList.get(resultList.size() - 1)[1] < left) {
                    resultList.add(new int[]{left, right});
                } else {
                    resultList.get(resultList.size() - 1)[1] = Math.max(resultList.get(resultList.size() - 1)[1], right);
                }

            }

            return resultList.toArray(new int[resultList.size()][]);
        }
    }

    /**
     * 丑陋的代码，思路不清晰
     */
    static class Solution2 {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[][]{};
            if (intervals.length == 1) return intervals;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> resultList = new ArrayList<>();

            //输入
            //[[1,3],[2,6],[8,10],[15,18]]
            //输出
            //[[1,3],[2,6],[8,10],[15,18]]
            //预期结果
            //[[1,6],[8,10],[15,18]]

            int[] inner = intervals[0];
            for (int i = 0; i < intervals.length - 1; i++) {

                if (intervals[i + 1][0] <= inner[1]) {

                    int[] temp = new int[2];
                    temp[0] = intervals[i][0];
                    temp[1] = Math.max(inner[1], intervals[i + 1][1]);

                    inner = temp;
                    i++;
                } else {
                    resultList.add(inner);
                    inner = intervals[i];
                    if (i == intervals.length - 2 && intervals.length > 2) {
                        resultList.add(intervals[intervals.length - 2]);
                        resultList.add(intervals[intervals.length - 1]);
                    } else if (i == intervals.length - 2 && intervals.length <= 2) {
                        resultList.add(intervals[intervals.length - 1]);
                    }
                }
            }

            if (resultList.size() == 0) {
                resultList.add(inner);
            }

            return resultList.toArray(new int[resultList.size()][]);
        }
    }


}
