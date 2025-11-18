package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 *  雷鸟创新一面
 */
class Test_No {

    public static void main(String[] args) {
        ObjectPool<StringBulder> pool = new ObjectPool<StringBulder>(
                () -> new StringBuilder(), (sb) -> {
            sb.clear()
        }, 100
        );

        StringBuilder sb = pool.getObject();
        pool.returnObject(sb);

    }

    public class ObjectPool<T> {
        private Queue queue = new ConcurrentLinkdQueue();
        int maxSize;
        private Supplier<T> supplier;
        private Consumer<T> consumer;

        public ObjectPool(Supplier<T> supplier,
                          Consumer<T> consumer, int maxSize) {
            this.supplier = supplier;
            this.consumer = consumer;
            this.maxSize = maxSize;
        }

        public T getObject() {
            T object = null;
            if (queue.size > 0) {
                object = queue.poll();
            } else {
                object = supplier.get();
            }
            return object;
        }

        public void returnObject(T object) {
            if (object != null && queue.size() < maxSize) {
                if (consumer != null) {
                    consumer.accept(object);
                }
                queue.offer(object);
            }
        }

        public int getCount() {
            return queue.size();
        }
    }


    /**
     *
     * 自己手写的
     */
    public class ObjectPool<T> {

        private Queue queue = new ConcurrentLinkedQueue<>();

        private Supplier<T> supplier;

        private int maxSize;

        Public ObjectPool(Supplier<T> supplier, int size, Consumer<T> consumer) {

            this.supplier = supplier;

            this.maxSize = maxSize;

            this.consumer = consumer;

        }


        public T getObject() {

            T object = null;

            if (queue.size() > 0) {
                object = queue.poll();

            } else {
                object = supplier.get();

            }
            return object;
        }


        public void backObject(T object) {
            if (object != null && queue.size() < maxSize) {

                if (consumer != null) {
                    consumer.callback(object)
                }

                queue.offer(object)
            }
        }

        public int getCount () {
            return queue.size();
        }
    }


}
