package com.example.myworld.thread;

import java.util.LinkedList;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/23
 * Description:
 */
class TestConsumer2_O {

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
                if (list.size() < num) {
                    System.out.println("consumer thread id------>"+Thread.currentThread().getId());
                    System.out.println("【to consume count】:" + num + "\t【remain】:" + list.size() + "\tcannot do consume!");
                    try {
                        list.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("consumer thread id---2--->"+Thread.currentThread().getId());

                for (int i = 0; i < num; i++) {
                    list.remove();
                }
                System.out.println("【this time consume】:" + num + "\t【remain】:" + list.size());

                list.notifyAll();
            }
        }

        @Override
        public  void product(int num) {
            synchronized (list) {
                if (list.size() + num > MAX_SIZE) {
                    System.out.println("product thread id------>"+Thread.currentThread().getId());
                    System.out.println("【to produce count】:" + num + "\t【remain】:" + list.size() + "\tcannot do produce!");
                    try {
                        list.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("product thread id---2--->"+Thread.currentThread().getId());

                for (int i = 0; i < num; i++) {
                    list.add(new Object());
                }

                System.out.println("【this time produce】:" + num + "\t【remain】:" + list.size());
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
