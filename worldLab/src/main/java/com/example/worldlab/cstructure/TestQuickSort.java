package com.example.myworld.cstructure;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/2
 * Description:
 * <p>
 * - 排序算法总结 (代码较好)
 * - https://www.runoob.com/w3cnote/sort-algorithm-summary.html
 * <p>
 * <p>
 * - 十大排序算法 (图文结合较好)
 * - https://www.cnblogs.com/fengyumeng/p/10994279.html
 */
class TestQuickSort {

    public static void main(String[] args) {
        int array[] = {2, 8, 13, 7, 12, 15};
        int bArray[] = {8, 2, 5, 0, 7, 4, 6, 1};
        int cArray[] = {-1, 10, -3, 0, 8, 2, 5, 0, 7, 4, 6, 1};
        array = cArray;
//        sort(array);
        sort2(array);
        for (Integer aa : array) {
            System.out.println(aa.toString());
        }
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort2(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //切分
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * - 十大排序算法 (图文结合较好)
     * - https://www.cnblogs.com/fengyumeng/p/10994279.html
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                //小于基准值 则mark+1，并交换位置。
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    /**
     * 排序算法总结 (代码较好)
     * - https://www.runoob.com/w3cnote/sort-algorithm-summary.html
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l >= r)
            return;

        int i = l;
        int j = r;
        int key = a[i];//选择第一个数为key

        while (i < j) {

            while (i < j && a[j] >= key)//从右向左找第一个小于key的值
                j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < key)//从左向右找第一个大于key的值
                i++;

            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        quickSort(a, l, i - 1);//递归调用
        quickSort(a, i + 1, r);//递归调用
    }
}
