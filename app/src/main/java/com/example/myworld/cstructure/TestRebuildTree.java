package com.example.myworld.cstructure;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/14
 * Description:
 */
class TestRebuildTree {

    public static void main(String[] args) {
        int array[] = {
                6, 3, 9,
                3, 1, 4,
                1, 0, 2,
                2, 0, 0,
                4, 0, 5,
                5, 0, 0,
                9, 8, 10,
                8, 7, 0,
                7, 0, 0,
                10, 0, 0
        };
//        List<int[]> list = Arrays.asList(array);
//        Collections.addAll(new ArrayList<int[]>(), array);

        TreeNode head = getHeadNode(array);
        String result = TestTraverseTreeCengCi.serialize(head);
        System.out.println("traverse---->" + result);

        String frontResult = TestTraverseTreeFront.serialize(head);
        System.out.println("traverse--front-->" + frontResult);

        String midResult = TestTraverseTreeMid.serialize(head);
        System.out.println("traverse--mid-->" + midResult);
    }

    public static TreeNode getHeadNode(int[] array) {
        List<List<Integer>> groupList = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (i % 3 == 0) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(array[i]);
                innerList.add(array[i + 1]);
                innerList.add(array[i + 2]);
                groupList.add(innerList);
            }
        }
        List<TreeNode> headList = new ArrayList<>();

        for (List<Integer> innerList : groupList) {
            TreeNode headNode = new TreeNode(innerList.get(0));

            int leftValue = innerList.get(1);
            if (leftValue != 0) {
                TreeNode node = findValueInList(leftValue, headList);
                if (node != null) {
                    headNode.left = node;
                } else {
                    headNode.left = new TreeNode(leftValue);
                }

            } else {
                headNode.left = null;
            }

            int rightValue = innerList.get(2);
            if (rightValue != 0) {
                TreeNode node = findValueInList(rightValue, headList);
                if (node != null) {
                    headNode.right = node;
                } else {
                    headNode.right = new TreeNode(rightValue);
                }
            } else {
                headNode.right = null;
            }
            headList.add(headNode);
        }

        return headList.get(headList.size() - 1);
    }

    public static TreeNode findValueInList(int value, List<TreeNode> list) {
        TreeNode resultNode = null;
        for (TreeNode node : list) {
            if (node.val == value) {
                resultNode = node;
                break;
            }
        }
        return resultNode;

    }
}
