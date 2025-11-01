package com.example.myworld.thread;

import java.util.Stack;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/23
 * Description:
 */
class TestBlockQueue2 {

    public static class MyBlockQueue<T> {
        //push锁
        private final static Object pushLock = new Object();
        //pop锁
        private final static Object popLock = new Object();

        //数据存储
        private Stack<T> stack;
        //队列最大长度
        private  int maxSize = 0;
        //队列最小长度
        private int minSize = 0;
        public MyBlockQueue(int size) {
            this.maxSize = size;
            stack = new Stack<T>();
        }

        public synchronized void push(T t) {
            if(stack.size() >= maxSize) {
                System.out.println("队列满");
                pushLock();
            }
            stack.push(t);
            popUnLock();
        }

        public synchronized T pop() {
            if(stack.size() == minSize) {
                System.out.println("队列空");
                popLock();
            }
            T t = stack.pop();
            pushUnLock();
            return t;
        }

        private void pushLock() {
            synchronized (pushLock) {
                try {
                    //该行要在wait之前进行，否则执行不到
                    System.out.println("push Lock wait");
                    pushLock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void pushUnLock() {
            synchronized (pushLock) {
                pushLock.notify();
            }
        }

        private  void popLock() {
            synchronized (popLock) {
                try {
                    //该行要在wait之前进行，否则执行不到
                    System.out.println("pop Lock wait");
                    popLock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void  popUnLock() {
            synchronized (popLock) {
                popLock.notify();
            }
        }

    }

    public static void main(String[] args) {
        try{
            MyBlockQueue<Integer> blockQueue = new MyBlockQueue<Integer>(3);
            blockQueue.push(1);
            System.out.println(blockQueue.pop());
            blockQueue.push(2);
            System.out.println(blockQueue.pop());
            blockQueue.push(3);
            System.out.println(blockQueue.pop());

            blockQueue.push(5);
            blockQueue.push(5);
            blockQueue.push(5);
            blockQueue.push(5);
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            blockQueue.push(6);
            System.out.println(blockQueue.pop());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
