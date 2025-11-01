package com.example.myworld.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/13
 * Description:
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，
 * 盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。
 * 移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 *
 *
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * <p>
 * https://leetcode-cn.com/problems/hanota-lcci/solution/yi-nuo-ta-di-gui-by-gui-ji-hong-uop6/
 */
class TestHanota {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
//        for (Integer value : A) {
//            System.out.println("result----->" + value);
//        }
//        List<Integer> A = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        Solution.hanota(A, B, C);
        for (Integer value : C) {
            System.out.println("result----->" + value);
        }
    }

    static class Solution {
        public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            move(A.size(), A, B, C);
        }

        private static void move(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
            if (size == 1) {
                c.add(a.remove(a.size() - 1));
                return;
            }
            // A,借助C,将A中n-1个盘子放到B上
            move(size - 1, a, c, b);
            // A 最底下的盘子放到C上
            Integer remove = a.remove(a.size() - 1);
            c.add(remove);
            // B 借助 A，将B中所有盘子，移动到C上
            move(size - 1, b, a, c);
        }
    }

}
