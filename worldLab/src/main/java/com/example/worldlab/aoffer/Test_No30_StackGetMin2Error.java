package com.example.myworld.aoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * <p>
 * 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 155. 最小栈
 * <p>
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * <p>
 * https://leetcode-cn.com/problems/min-stack/
 *
 * 自己实现的有问题
 * Error Error Error Error Error
 * Error Error Error Error Error
 */
class Test_No30_StackGetMin2 {

    public static void main(String[] args) {

    }

    class MinStack {

        private List<Integer> list;

        private int min;
        private int lastMin;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            lastMin = min();
            list.add(x);
            min = Math.min(lastMin, x);
            
        }

        //3 1 5 7

        public void pop() {
            if (list.size() > 0) {

                int value = list.get(list.size() - 1);
                list.remove(list.size() - 1);

                if (value == min) {
                    min = lastMin;
                }
                lastMin = min;
            }
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int min() {
            if (list.size() == 1) {
                return list.get(0);
            }
            return min;
        }
    }

}
