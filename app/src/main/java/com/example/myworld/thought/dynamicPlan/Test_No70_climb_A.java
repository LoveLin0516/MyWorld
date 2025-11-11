package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * https://leetcode.cn/problems/climbing-stairs/
 */
class Test_No70_climb {

    public static void main(String[] args) {

    }

    //见斐波那契数列

    public int climbStairs2(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        } else{
            return climbStairs(n-2)+climbStairs(n-1);
        }
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1;
            int b = 2;
            int c = 0;
            int index = 0;
            while (index < n-2) {
                c = a+b;
                a=b;
                b=c;
                index++;
            }
            return c;
        }
    }
}
