package com.example.myworld.cafail;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 虎牙一面算法题
 */
class Test_No70_offer10_Steps {

    public static void main(String[] args) {

    }

    //见斐波那契数列

    //1 1 2 3 5
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
            while (index < n-2) { //这个判断条件正确，leetCode提交通过
                c = a+b;
                a=b;
                b=c;
                index++;
            }
            return c;
        }
    }

}
