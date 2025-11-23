package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/16
 * Description:
 *
 * Java 实现一个线程安全的 单例 ExploreManager
 *
 * https://chat.deepseek.com/a/chat/s/1caa13b3-8dbe-48a0-8629-0985a56cb00a
 */
class TestSingleInstance_S {

    public static void main(String[] args) {
        ExploreManager.getInstance().explore();
    }

    public static class ExploreManager {

        private static ExploreManager sInstance3 = new ExploreManager();

        private static final class Handler {
            public static ExploreManager sInstance4 = new ExploreManager();
        }

        //我们知道，构造方法被私有化，就无法在类外部实例化Singleton对象。
        //Java 构造方法私有化与单例模式
        //https://blog.csdn.net/wei_zhi/article/details/52832334
        private ExploreManager() {
        }

//        public static ExploreManager getInstance() {
//            synchronized (ExploreManager.class) {
//                if (sInstance == null) {
//                    sInstance = new ExploreManager();
//                }
//                return sInstance;
//            }
//        }

        //饿汉模式（线程安全）
        public static ExploreManager getInstance3() {
            return sInstance3;
        }

        //懒汉模式（非线程安全）
        public static ExploreManager getInstance() {
            if (sInstance == null) {
                sInstance = new ExploreManager();
            }
            return sInstance;
        }

        //懒汉模式（线程安全）
        public static synchronized ExploreManager getInstance1() {
            if (sInstance == null) {
                sInstance = new ExploreManager();
            }
            return sInstance;
        }


        /**
         *
         * 懒汉式（双重检查锁定）：
         *
         * 优点：延迟加载，只有在需要时才创建实例。
         *
         * 注意：必须使用volatile关键字来禁止指令重排序，因为instance = new ExploreManager();
         * 这行代码并不是原子操作，它分为三个步骤：分配内存空间、初始化对象、将对象指向分配的内存地址。
         * 如果没有volatile，可能会发生指令重排序，导致一个线程拿到一个未完全初始化的对象。
         */

        //懒汉模式 双重锁检测法（线程安全）
        //将sInstance 声明为volatile
        private static volatile ExploreManager sInstance;
        //懒汉模式 双重锁检测法（线程安全）
        public static ExploreManager getInstance2() {
            if (sInstance == null) {
                synchronized (ExploreManager.class) {
                    if (sInstance == null) {
                        sInstance = new ExploreManager();
                    }
                }
            }
            return sInstance;
        }



        /**
         *
         * 静态内部类方式：
         *
         * 优点：实现简单，无需同步，利用类加载机制保证线程安全，同时实现了延迟加载。
         *
         * 原理：当调用getInstance方法时，才会加载Holder类，然后创建ExploreManager实例。
         * 类加载过程是线程安全的。
         */
        //静态类内部加载（线程安全）
        public static ExploreManager getInstance4() {
            return Handler.sInstance4;
        }

        public void explore() {

        }
    }

    //枚举类=实现单例，线程安全，无法满足继承的情况
    enum Explore {
        INSTANCE,
        INS2;
        public void doSth() {
            System.out.println("doSth----->");
        }
    }

    class Test2 {
        void doSth() {
            ExploreManager exploreManager = new ExploreManager();
            exploreManager.explore();

            ExploreManager.getInstance().explore();
            ExploreManager.getInstance4().explore();

            Explore.INSTANCE.doSth();
        }
    }
}
