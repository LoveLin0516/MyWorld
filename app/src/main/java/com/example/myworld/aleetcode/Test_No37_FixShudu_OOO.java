package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 *
 * 37. 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * https://leetcode-cn.com/problems/sudoku-solver/comments/
 */
class Test_No37_FixShudu_OOO {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        solution.printBoard(board);
        solution.solveSudoku(board);
        solution.printBoard(board);
    }

    /**
     * lvliang
     * lvliang
     * 2019-03-05
     * @Angus-Liu 递归和回溯想不明白，编程小菜鸟想求指教
     *
     * angus-liu
     * Angus-Liu
     * 2019-03-06
     * @lvliang 因为 num 只要满足关系 !row[i][num] && !col[j][num] && !block[blockIndex][num]
     * 就可以在 board[i][j] 处填上 num。很显然，num 的取值不是唯一的，
     * 所以需要先假定 board[i][j] = num，之后再找寻下一个空位置，以上方同样的关系的进行数独求解。
     * 假设在 board[i][j] 处填上 num 使得数独无解，就需要进行回溯，
     * 消除 num 在 row[i]，col[j]，block[i / 3 * 3 + j / 3] 中的标记，
     * 为 board[i][j] 赋予除 num 的另一个值，再次对数独进行递归求解
     */
    static class Solution {
        public void solveSudoku(char[][] board) {
            /**
             * 记录某行，某位数字是否已经被摆放
             */
            boolean[][] row = new boolean[9][9];
            /**
             * 记录某列，某位数字是否已经被摆放
             */
            boolean[][] col = new boolean[9][9];
            /**
             * 记录某 3x3 宫格内，某位数字是否已经被摆放
             */
            boolean[][] block = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        row[i][num] = true;
                        col[j][num] = true;
                        // blockIndex = i / 3 * 3 + j / 3，取整
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            dfs(board, row, col, block, 0, 0);
        }

        private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
            // 找寻空位置
            while (board[i][j] != '.') {
                if (++j >= 9) {
                    i++;
                    j = 0;
                }
                if (i >= 9) {
                    return true;
                }
            }
            for (int num = 0; num < 9; num++) {
                int blockIndex = i / 3 * 3 + j / 3;
                if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                    // 递归
                    board[i][j] = (char) ('1' + num);
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blockIndex][num] = true;
                    if (dfs(board, row, col, block, i, j)) {
                        return true;
                    } else {
                        // 回溯
                        row[i][num] = false;
                        col[j][num] = false;
                        block[blockIndex][num] = false;
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        }

        private void printBoard(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            char[][] board = new char[][]{
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            Solution solution = new Solution();
            solution.printBoard(board);
            solution.solveSudoku(board);
            solution.printBoard(board);
        }
    }
}
