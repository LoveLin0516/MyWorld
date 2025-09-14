package com.example.myworld.aoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/5/4
 * Description:
 * <p>
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * <p>
 *
 *
 *
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 */
class Test_No59_QueueGetMax_O {

    public static void main(String[] args) {

    }

    class MaxQueue {
        private List<Integer> list = new ArrayList<>();
        private Deque<Integer> maxList = new LinkedList<>();

        public MaxQueue() {
        }

        public int max_value() {
            if (maxList.isEmpty()) {
                return -1;
            }
            return maxList.getFirst();
        }

        /**
         * 栈最小值和队列最大值都是递减数列
         */
        public void push_back(int value) {
            list.add(value);
            if (maxList.isEmpty()) {
                maxList.offerLast(value);
            } else {
                while (!maxList.isEmpty() && maxList.getLast() < value) {
                    maxList.pollLast();
                }
                maxList.offerLast(value);
            }
        }

        public int pop_front() {
            int value = -1;
            if (list.size() > 0) {
                value = list.remove(0);
                if (!maxList.isEmpty() && value == maxList.getFirst()) {
                    maxList.removeFirst();
                }

            }
            return value;
        }
    }


}
