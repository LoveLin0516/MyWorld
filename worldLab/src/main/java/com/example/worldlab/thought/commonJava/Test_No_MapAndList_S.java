package com.example.myworld.aleetcode;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/30
 * Description:
 *
 * 遍历并修改List
 *
 * 题目：有一个ArrayList，里面存放了若干字符串。请编写代码，安全地移除其中所有值为 "remove" 的元素。
 *
 * 考察点：理解快速失败（Fail-Fast） 机制，知道直接使用for-each循环或Iterator遍历时调用List.remove()会抛出ConcurrentModificationException。正确的做法是使用Iterator.remove()。
 *
 * HashMap的遍历与使用
 *
 * 题目：遍历一个HashMap，并打印出所有的键和值。
 *
 * 考察点：熟悉HashMap的几种遍历方式（通过keySet()、values()、entrySet()），并理解entrySet是最高效的方式。    Java实现这两道题
 *
 * https://chat.deepseek.com/a/chat/s/044cdbea-605d-423e-906f-4d74817209cf
 *
 *
 */
import java.util.*;
class Test_No_MapAndList_S {

    public static void main(String[] args) {


    }

    public static class ListTraversal {

        public static void main(String[] args) {
            // 创建并初始化ArrayList
            List<String> list = new ArrayList<>();
            list.add("hello");
            list.add("remove");
            list.add("world");
            list.add("remove");
            list.add("java");
            list.add("remove");

            System.out.println("原始列表: " + list);

            // 方法1：使用Iterator的remove()方法（推荐）
            removeWithIterator(list);

            // 重新初始化列表进行第二种方法演示
            list = new ArrayList<>();
            list.add("hello");
            list.add("remove");
            list.add("world");
            list.add("remove");
            list.add("java");
            list.add("remove");

            // 方法2：使用removeIf()方法（Java 8+）
            removeWithRemoveIf(list);

            // 重新初始化列表进行第三种方法演示
            list = new ArrayList<>();
            list.add("hello");
            list.add("remove");
            list.add("world");
            list.add("remove");
            list.add("java");
            list.add("remove");

            // 方法3：使用传统for循环（从后往前遍历）
            removeWithForLoop(list);
        }

        /**
         * 方法1：使用Iterator遍历并安全移除元素
         * 这是最标准和推荐的方式
         */
        private static void removeWithIterator(List<String> list) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                if ("remove".equals(element)) {
                    iterator.remove(); // 安全移除当前元素
                }
            }
            System.out.println("Iterator移除后: " + list);
        }

        /**
         * 方法2：使用removeIf()方法（Java 8+）
         * 代码更简洁，内部使用Iterator实现
         */
        private static void removeWithRemoveIf(List<String> list) {
//            list.removeIf(element -> "remove".equals(element));
//            System.out.println("removeIf移除后: " + list);
        }

        /**
         * 方法3：使用传统for循环从后往前遍历
         * 避免了索引错位的问题
         */
        private static void removeWithForLoop(List<String> list) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if ("remove".equals(list.get(i))) {
                    list.remove(i);
                }
            }
            System.out.println("For循环移除后: " + list);
        }
    }

    public static class HashMapTraversal {

        public static void main(String[] args) {
            // 创建并初始化HashMap
            Map<String, Integer> map = new HashMap<>();
            map.put("Alice", 25);
            map.put("Bob", 30);
            map.put("Charlie", 35);
            map.put("Diana", 28);

            System.out.println("HashMap内容:");

            // 方法1：使用entrySet()遍历（最高效，推荐）
            System.out.println("\n1. 使用entrySet()遍历:");
            traverseWithEntrySet(map);

            // 方法2：使用keySet()遍历
            System.out.println("\n2. 使用keySet()遍历:");
            traverseWithKeySet(map);

            // 方法3：使用values()遍历（只获取值）
            System.out.println("\n3. 使用values()遍历:");
            traverseWithValues(map);

            // 方法4：使用Java 8的forEach方法
            System.out.println("\n4. 使用forEach方法:");
            traverseWithForEach(map);

            // 方法5：使用Iterator遍历
            System.out.println("\n5. 使用Iterator遍历:");
            traverseWithIterator(map);
        }

        /**
         * 方法1：使用entrySet()遍历（最高效）
         * 直接获取键值对，避免了通过key查找value的开销
         */
        private static void traverseWithEntrySet(Map<String, Integer> map) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }

        /**
         * 方法2：使用keySet()遍历
         * 先获取所有key，再通过key获取value
         */
        private static void traverseWithKeySet(Map<String, Integer> map) {
            for (String key : map.keySet()) {
                Integer value = map.get(key);
                System.out.println("Key: " + key + ", Value: " + value);
            }
        }

        /**
         * 方法3：使用values()遍历
         * 只获取值，无法获取对应的key
         */
        private static void traverseWithValues(Map<String, Integer> map) {
            for (Integer value : map.values()) {
                System.out.println("Value: " + value);
            }
        }

        /**
         * 方法4：使用Java 8的forEach方法
         * 代码简洁，使用lambda表达式
         */
        private static void traverseWithForEach(Map<String, Integer> map) {
//            map.forEach((key, value) ->
//                    System.out.println("Key: " + key + ", Value: " + value));
        }

        /**
         * 方法5：使用Iterator遍历
         * 可以在遍历时安全地移除元素
         */
        private static void traverseWithIterator(Map<String, Integer> map) {
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }



}
