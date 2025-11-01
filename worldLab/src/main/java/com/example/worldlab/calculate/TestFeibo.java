package com.example.myworld.calculate;

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/16
 * Description:
 */
class TestFeibo {

    // 1 1 2 3 5 8 13 21 34 55
    public static void main(String args[]) {

        System.out.println("zhangzhirui---->" + zhangzhirui(9));
        System.out.println("zhangzhirui--2-->" + zhangzhirui2(9));
    }

    public static int zhangzhirui(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return zhangzhirui(n - 1) + zhangzhirui(n - 2);
        }
    }

    public static int zhangzhirui2(int n) {
        int c = 0;
        int a = 1;
        int b = 1;
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            while (n - 2 >= 0) {
                n--;
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
