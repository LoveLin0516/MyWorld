package com.example.myworld.thread;

import java.util.LinkedList;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/23
 * Description:
 */
class TestConsumer_S {

    public interface AbstractStorage {
        void consume(int num);

        void product(int num);
    }


    public static class Storage implements AbstractStorage {
        private final int MAX_SIZE = 100;
        private LinkedList list = new LinkedList();

        @Override
        public void consume(int num) {
            synchronized (list) {
                while (list.size() < num) {
                    System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行消费任务!");
                    try {
                        list.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < num; i++) {
                    list.remove();
                }
                System.out.println("【本次消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

                list.notifyAll();
            }
        }

        @Override
        public  void product(int num) {
            synchronized (list) {
                while (list.size() + num > MAX_SIZE) {
                    System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生成任务!");
                    try {
                        list.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                for (int i = 0; i < num; i++) {
                    list.add(new Object());
                }

                System.out.println("【本次生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
                list.notifyAll();
            }
        }
    }


    public static class Producer extends Thread {
        private int num;
        public AbstractStorage abstractStorage;

        public Producer(AbstractStorage abstractStorage) {
            this.abstractStorage = abstractStorage;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void produce(int num) {
            abstractStorage.product(num);
        }

        @Override
        public void run() {
            produce(num);
        }
    }


    public static class Consumer extends Thread {
        private int num;
        public AbstractStorage abstractStorage;

        public Consumer(AbstractStorage abstractStorage) {
            this.abstractStorage = abstractStorage;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void consume(int num) {
            this.abstractStorage.consume(num);
        }

        @Override
        public void run() {
            consume(num);
        }
    }

    public static void main(String[] args) {
        AbstractStorage abstractStorage = new Storage();

        // 生产者对象
        Producer p1 = new Producer(abstractStorage);
        Producer p2 = new Producer(abstractStorage);
        Producer p3 = new Producer(abstractStorage);
        Producer p4 = new Producer(abstractStorage);
        Producer p5 = new Producer(abstractStorage);
        Producer p6 = new Producer(abstractStorage);
        Producer p7 = new Producer(abstractStorage);

        // 消费者对象
        Consumer c1 = new Consumer(abstractStorage);
        Consumer c2 = new Consumer(abstractStorage);
        Consumer c3 = new Consumer(abstractStorage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(20);
        p3.setNum(30);
        p4.setNum(40);
        p5.setNum(30);
        p6.setNum(20);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(70);
        c3.setNum(20);

        c1.start();
        c2.start();
        c3.start();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
