package com.example.myworld.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/23
 * Description:
 */
class TestBlockQueue {

    public static class BlockQueue<T> {

        private int size;
        private Object[] queue;

        private Lock lock = new ReentrantLock();
        private Condition full = lock.newCondition();
        private Condition empty = lock.newCondition();

        private int index;
        private int removeIndex;
        private int currLen;

        public BlockQueue() {
            this(10);
        }

        public BlockQueue(int size) {
            this.index = 0;
            this.removeIndex = 0;
            this.currLen = 0;
            this.size = size;
            queue = new Object[size];
        }

        public void push(T element) throws InterruptedException {
            lock.lock();
            try {
                while (currLen == size) {
                    System.out.println("队列满。。。");
                    //该行要在wait之前进行，否则执行不到
                    System.out.println("push Lock wait");
                    full.await();
                }
                queue[index] = element;
                if (++index == size) {
                    index = 0;
                }
                currLen++;
                empty.signal();
            } finally {
                lock.unlock();
            }
        }

        public T pop() throws InterruptedException {
            lock.lock();
            try {
                while (currLen == 0) {
                    System.out.println("队列空。。。");
                    //该行要在wait之前进行，否则执行不到
                    System.out.println("pop Lock wait");
                    empty.await();
                }
                Object obj = queue[removeIndex];
                if (++removeIndex == size) {
                    removeIndex = 0;
                }
                currLen--;
                full.signal();
                return (T) obj;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        try{
            BlockQueue<Integer> blockQueue = new BlockQueue<Integer>(3);
            blockQueue.push(1);
            System.out.println(blockQueue.pop());
            blockQueue.push(2);
            System.out.println(blockQueue.pop());
            blockQueue.push(3);
            System.out.println(blockQueue.pop());

            blockQueue.push(5);
            blockQueue.push(5);
            blockQueue.push(5);
//            blockQueue.push(5);
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
            System.out.println(blockQueue.pop());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}


