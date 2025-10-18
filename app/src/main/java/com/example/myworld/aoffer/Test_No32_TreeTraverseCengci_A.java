package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 */
class Test_No32_TreeTraverseCengci {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[]{};
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (queue.size() > 0) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    size--;
                }
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }


}
