package com.example.worldlab.cafail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 *  富途二面算法题
 *  100w人  找出身高最高的100个人
 *
 * - https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * - [215. 数组中的第K个最大元素]
 *
 * 215. Kth Largest Element in an Array - 找第K大的元素
 *
 * 703. Kth Largest Element in a Stream - 数据流中的第K大元素
 *
 * 347. Top K Frequent Elements - 前K个高频元素（类似思路）
 *
 *
 * 时间复杂度：O(n log k)，其中 n=1,000,000，k=100
 *
 * 空间复杂度：O(k)，只维护100个元素的堆
 *
 * 优势：不需要对所有100万人进行排序，内存使用很少
 *
 */
class Test_No_Top100Height {

    public static void main(String[] args) {


    }

    public static class Top100Tallest {

        /**
         * 找出身高最高的100个人
         * @param heights 所有人的身高数组
         * @return 身高最高的100个人的身高列表（降序排列）
         */
        public static List<Integer> findTop100Tallest(int[] heights) {
            if (heights == null || heights.length == 0) {
                return new ArrayList<>();
            }

            // 使用最小堆，只保留最大的100个元素
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int k = 100;

            for (int height : heights) {
                if (minHeap.size() < k) {
                    // 堆未满，直接加入
                    minHeap.offer(height);
                } else if (height > minHeap.peek()) {
                    // 当前身高大于堆顶，替换堆顶元素
                    minHeap.poll();
                    minHeap.offer(height);
                }
                // 否则忽略这个身高
            }

            // 将堆中的元素转为列表并降序排列
            List<Integer> result = new ArrayList<>(minHeap);
            Collections.sort(result, Collections.reverseOrder());

            return result;
        }

        /**
         * 测试方法
         */
        public static void main(String[] args) {
            // 模拟100万人的身高数据（150cm - 220cm）
            int[] heights = new int[1_000_000];
            Random random = new Random();
            for (int i = 0; i < heights.length; i++) {
                heights[i] = 150 + random.nextInt(71); // 150-220cm
            }

            long startTime = System.currentTimeMillis();
            List<Integer> top100 = findTop100Tallest(heights);
            long endTime = System.currentTimeMillis();

            System.out.println("最高的100个人身高：");
            for (int i = 0; i < top100.size(); i++) {
                System.out.printf("第%d名: %dcm\n", i + 1, top100.get(i));
            }
            System.out.printf("\n处理100万人数据耗时: %dms\n", endTime - startTime);
        }
    }


}
