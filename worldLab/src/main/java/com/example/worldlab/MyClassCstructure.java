package com.example.worldlab;

import com.example.myworld.cstructure.TestKGroupReverse;
import com.example.myworld.cstructure.bean.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class MyClassCstructure {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = root;

        System.out.println(getHeight(root2));
        System.out.println(getHeightByCengci(root2));


        int array[] = {2, 8, 13, 7, 12, 15};
        int bArray[] = {8, 2, 5, 0, 7, 4, 6, 1};
        int cArray[] = {-1, 10, -3, 0, 8, 2, 5, 0, 7, 4, 6, 1};
        quickSort(array, 0, array.length - 1);
//        array = cArray;
        for (Integer aa : array) {
            System.out.println(aa.toString());
        }
    }

    /**
     * 递归获取树高度
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    /**
     * 层次遍历获取树高度
     */
    public static int getHeightByCengci(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int height = 1;

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null) {
                height++;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                // return height;
                // do nothing
            }

        }

        return height;
    }

    //1 2 3 4 5
    //2 1 3 4 5

    /**
     * 链表反转
     */
    public static ListNode reverseList(ListNode a) {
        ListNode pre = null;
        ListNode cur = a;
        while (cur != null) {
            ListNode temp = cur.next; // temp=2;
            cur.next = pre; //1.next=null
            pre = cur; //pre=1
            cur = temp;//cur=2
        }
        return pre;
    }

    /**
     * k个一组反转链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    /**
     * 链表是否有环
     */
    public static boolean isLinkedListContainsLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        int count = 0;
        while (slow != null && fast != null) {

            count++;
            if (slow == fast) {
                System.out.println("length----->" + count);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    /**
     * 链表是否有环， 环长，环的起点，全长，起点到环的距离
     */
    public static ListNode getLoopStartNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        int count = 0;
        while (slow != null && fast != null) {

            count++;
            if (slow == fast) {
                System.out.println("length----->" + count);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode thirdNode = head.next;
        int singleLength = 0;
        while (thirdNode != null && fast != null) {
            singleLength++;
            if (thirdNode == fast) {
                break;
            }
            thirdNode = thirdNode.next;
            fast = fast.next;
        }

        System.out.println("total length----->" + singleLength + count);
        return thirdNode;
    }

    /**
     * 快排
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        int aim = a[l];
        while (i < j) {
            while (i < j && a[j] > aim) {
                j--;
            }

            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < aim) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }

        }
        //i == j
        a[i] = aim;
        quickSort(a, l, i - 1);
        quickSort(a, i + 1, r);
    }

    /**
     * 序列化
     */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * 层次遍历序列化
     */
    public static String serializeByCengci(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode treeNode = queue.peek();
            if (treeNode != null) {
                sb.append(treeNode.val).append(",");
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);

                queue.poll();
            } else {
                sb.append("#").append(",");
                queue.poll();
            }
        }


        return sb.toString();
    }

    /**
     * 序列化
     */
    public static TreeNode deSerialize(String result) {
        String[] array = result.split(",");

        List<String> list = Arrays.asList(array);
        if (list.size() == 0 || list.get(0).equals("#")) {
            return null;
        }
        return deSerialize(list);
    }

    /**
     * 先序遍历
     */
    public static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    /**
     * 先序遍历, 反序列化
     */
    public static TreeNode deSerialize(List<String> list) {
        if (list.size() == 0 || list.get(0).equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(list.get(0));
        list.remove(0);

        treeNode.left = deSerialize(list);
        treeNode.right = deSerialize(list);
        return treeNode;
    }


    /**
     * 中序遍历
     */
    public static void midOrderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        serialize(root.left, sb);
        sb.append(root.val).append(",");
        serialize(root.right, sb);
    }

    /**
     * 后序遍历
     */
    public static void backOrderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val).append(",");

    }

    /**
     * 后续遍历, 反序列化
     */
    public static TreeNode backOrderDeSerialize(List<String> list) {
        if (list.size() == 0 || list.get(list.size() - 1).equals("#")) {
            return null;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(list.get(list.size() - 1));
        list.remove(list.size() - 1);

        treeNode.right = deSerialize(list);
        treeNode.left = deSerialize(list);

        return treeNode;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = array.length - 1; j > i; j--) {

                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

}