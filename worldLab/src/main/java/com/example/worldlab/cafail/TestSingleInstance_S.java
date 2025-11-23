package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/16
 * Description:
 */
class TestSingleInstance {

    public static void main(String[] args) {
        ExploreManager.getInstance().explore();
    }

    public static class ExploreManager {
        private static ExploreManager sInstance;

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

        //懒汉模式 双重锁检测法（线程安全）
        //将sInstance 声明为volatile
//        private static volatile ExploreManager sInstance;

        //饿汉模式（线程安全）
        public static ExploreManager getInstance3() {
            return sInstance3;
        }

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
