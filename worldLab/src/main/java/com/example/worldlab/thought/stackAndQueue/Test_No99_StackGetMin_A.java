package com.example.myworld.cafail;

import java.util.Stack;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 抖音二面算法题
 *
 * 要使用栈实现栈的功能，并添加一个getMin方法，可以在每个操作（如push和pop）时维护一个辅助栈，这个辅助栈用于存储当前栈中的最小元素。下面是具体的实现方法：
 *
 * 创建两个栈，mainStack用于存储所有元素，minStack用于存储每个状态下的最小元素。
 * 当调用push方法时，将元素压入mainStack，同时检查minStack的顶部元素，如果新元素小于或等于minStack的顶部元素，则也将新元素压入minStack。
 * 当调用pop方法时，从mainStack弹出元素，如果弹出的元素等于minStack的顶部元素，则也从minStack弹出。
 * getMin方法简单地返回minStack的顶部元素，即为当前栈中的最小元素。
 *
 *
 * 155 最小栈
 * https://leetcode.cn/problems/min-stack/?
 */
class Test_No99_StackGetMin {

    public static void main(String[] args) {

    }

    public class MinStack {
        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;

        public MinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
            // 如果minStack为空，或者x小于或等于minStack的顶部元素，将x压入minStack
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (mainStack.isEmpty()) {
                return;
            }
            int poppedElement = mainStack.pop();
            // 如果弹出的元素是minStack的顶部元素，也从minStack中弹出
            if (poppedElement == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


}
