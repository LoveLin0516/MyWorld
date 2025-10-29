package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * 63. 不同路径 II
 *
 *
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 *
 * 返回机器人能够到达右下角的不同路径数量。
 *
 * 测试用例保证答案小于等于 2 * 109。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 *
 * https://leetcode.cn/problems/unique-paths-ii/
 *
 */
class Test_No63_uniquePaths2 {

    public static void main(String[] args) {

    }

    /**
     * 用这个
     */
    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            int[][] dp = new int[n][m];

            for(int i = 0 ;i < m;i ++){
                if(obstacleGrid[0][i] == 1)break;
                dp[0][i] = 1;
            }
            for(int i = 0 ;i < n;i ++){
                if(obstacleGrid[i][0] == 1) break;
                dp[i][0] = 1;
            }


            for(int i = 1 ; i < n;i ++){
                for(int j = 1  ;j < m;j ++){
                    if(obstacleGrid[i][j] == 0){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[n-1][m-1];
        }
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length, m = obstacleGrid[0].length;
            int[] f = new int[m];

            f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        f[j] = 0;
                        continue;
                    }
                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                        f[j] += f[j - 1];
                    }
                }
            }

            return f[m - 1];
        }
    }


}
