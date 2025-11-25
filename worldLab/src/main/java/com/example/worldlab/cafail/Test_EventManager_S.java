package com.example.myworld.aleetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;


/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 * <p>
 *
 * 大宇无限一面
 */
class Test_EventManager_S {

    public static void main(String[] args) {

    }

    public class EventManager<T> {
        private final List<Consumer<T>> listeners = new CopyOnWriteArrayList<>();

        /**
         * 添加监听器
         */
        public void addListener(Consumer<T> listener) {
            if (listener != null) {
                listeners.add(listener);
            }
        }

        /**
         * 移除监听器
         */
        public void removeListener(Consumer<T> listener) {
            if (listener != null) {
                listeners.remove(listener);
            }
        }

        /**
         * 通知所有监听器
         */
        public void notifyListeners(T event) {
            for (Consumer<T> listener : listeners) {
                try {
                    listener.accept(event);
                } catch (Exception e) {
                    // 处理异常，避免影响其他监听器
                    System.err.println("Error notifying listener: " + e.getMessage());
                }
            }
        }

        /**
         * 获取监听器数量
         */
        public int getListenerCount() {
            return listeners.size();
        }

        /**
         * 清空所有监听器
         */
        public void clearListeners() {
            listeners.clear();
        }
    }


    public class SynchronizedEventManager<T> {
        private final List<Consumer<T>> listeners = new ArrayList<>();

        /**
         * 添加监听器
         */
        public synchronized void addListener(Consumer<T> listener) {
            if (listener != null && !listeners.contains(listener)) {
                listeners.add(listener);
            }
        }

        /**
         * 移除监听器
         */
        public synchronized void removeListener(Consumer<T> listener) {
            if (listener != null) {
                listeners.remove(listener);
            }
        }

        /**
         * 通知所有监听器
         */
        public void notifyListeners(T event) {
            List<Consumer<T>> copy;
            //减少锁持有时间
            synchronized (this) {
                copy = new ArrayList<>(listeners);
            }

            for (Consumer<T> listener : copy) {
                try {
                    listener.accept(event);
                } catch (Exception e) {
                    System.err.println("Error notifying listener: " + e.getMessage());
                }
            }
        }
    }




}
