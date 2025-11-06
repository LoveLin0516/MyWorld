package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * https://chat.deepseek.com/a/chat/s/bf6299b7-3457-4cbe-9b4f-6a178d98bcdb
 *
 *
 */
class Test_No {

    public static void main(String[] args) {
        ObjectPool<StringBulder> pool= new ObjectPool<StringBulder>(
                ()->new StringBuilder(), (sb)-> {sb.clear()},  100
        );

        StringBuilder sb = pool.getObject();
        pool.returnObject(sb);

    }

    public class ObjectPool<T>{
        private Queue queue= new ConcurrentLinkdQueue();
        prirvate int maxSize;
        private Supplier<T> supplier;
        private Consumer<T> consumer;

        public ObjectPool(Supplier<T> supplier,
        Consumer<T> consumer, int maxSize){
            this.supplier= supplier;
            this.consumer= consumer;
            this.maxSize=maxSize;
        }

        public T getObject(){
            T object =null;
            if(queue.size>0){
                object = queue.poll();
            }else{
                object = supplier.get();
            }
            return object;
        }
        public void returnObject(T object){
            if(object!=null && queue.size()< maxSize){
                if(consumer!=null){
                    consumer.accept(object)
                }
                queue.offer(object)
            }
        }

        public int getCount(){
            return queue.size();
        }
    }
}
