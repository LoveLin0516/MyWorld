package com.example.myworld.cafail;

//import android.os.Build;
//
//import androidx.annotation.RequiresApi;

import java.util.Random;

/**
 * Created by zhuqianglong@bigo.sg on 2021/4/6
 * Description:
 * <p>
 * 利用产生1-5随机数的函数，产生1-25 随机数的函数
 * <p>
 * 如何生成随机数
 * https://blog.csdn.net/eternal_yangyun/article/details/88365265
 *
 *
 *
 * 如何根据可以产生1-5随机数的函数自己产生1-7的随机数？
 * https://blog.csdn.net/sinat_23079759/article/details/52793122
 *
 *
 * 随机数产生转换-根据(1,5)随机数生成器，生成(1,7)之内的随机数
 * https://blog.csdn.net/zheng0518/article/details/50929826
 * 方法三
 *
 *
 * 产生1-5的随机函数，生成随机数1-7
 * http://blog.sina.com.cn/s/blog_a2ae2da90101olnj.html
 * 算法二思路
 *
 *
 * 喜马拉雅一面算法题
 */
class TestRandom {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("random5---->" + random5());
        }

        System.out.println("------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("random7---->" + random7());
        }

        System.out.println("------------");

        for (int i = 0; i < 10; i++) {
            System.out.println("random25---->" + random25());
        }

    }

    /**
     * @return 1-5 随机数
     */
    public static int random5() {
        return new Random().nextInt(5) + 1;
    }

    /**
     * @return 1-7 随机数
     */
    public static int random7() {
        int temp = random5() * 5 + random5() - 3;
        while (temp >= 24) {
            temp = random5() * 5 + random5() - 3;
        }
        return temp / 3;
    }

    /**
     * @return 1-25随机数
     */
    public static int random25() {
        return random5() * 5 + random5() - 5;
    }

    public class Rand {
        public void main(String[] args) {
            int[] arr = new int[30];
            for (int i = 0; i < 30; i++) {
                arr[i] = (int) (Math.random() * 10);
            }
            for (int i : arr) {
                System.out.print(i + "、");
            }
        }
    }

    public class Rand2 {
        public void main(String[] args) {
            int[] arr = new int[30];
            Random random = new Random();
            for (int i = 0; i < 30; i++) {
                arr[i] = random.nextInt(5 + 1) + 10 - 5;  //产生5~10之间的数
            }
            for (int i : arr) {
                System.out.print(i + "、");
            }
        }
    }
}
