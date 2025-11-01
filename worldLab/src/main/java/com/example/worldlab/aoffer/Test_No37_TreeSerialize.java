package com.example.myworld.aoffer;

import com.example.myworld.cstructure.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/31
 * Description:
 * <p>
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * 297. 二叉树的序列化与反序列化
 * <p>
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
class Test_No37_TreeSerialize {

    public static void main(String[] args) {

    }


    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeInternal(root, sb);
            return sb.toString();
        }

        private void serializeInternal(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(root.val).append(",");
            serializeInternal(root.left, sb);
            serializeInternal(root.right, sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] array = data.split(",");
//            Arrays.asList(array);
            List<String> list = new ArrayList<>();
            for (String ss : array) {
                list.add(ss);
            }

            return deserializeInternal(list);

        }

        private TreeNode deserializeInternal(List<String> list) {
            if (list.size() == 0) return null;

            TreeNode root = null;
            String first = list.remove(0);

            if (first.equals("null")) {
                return null;

            }

            root = new TreeNode(Integer.parseInt(first));

            root.left = deserializeInternal(list);
            root.right = deserializeInternal(list);
            return root;
        }
    }

}
