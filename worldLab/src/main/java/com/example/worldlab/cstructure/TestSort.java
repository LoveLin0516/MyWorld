package com.example.myworld.cstructure;

/**
 * Created by zhuqianglong@bigo.sg on 2021/3/25
 * Description:
 */
class TestSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 6, 10, 2};
//        bubbleSort2(array);
//        selectSort(array);
//        insertSort(array);
        quickSort(array, 0, array.length - 1);
        for (Integer value : array) {
            System.out.println("value--->" + value);
        }
    }

    private static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    private static void bubbleSort2(int array[]) {
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

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    private static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }

            }
        }
    }

    /**
     *{5, 3, 1, 2, 6, 10, 2};
     *{2, 3, 1, 2, 6, 10, 2};
     *{2, 3, 1, 2, 6, 10, 6};
     *             i   j
     *{2, 3, 1, 2, 5, 10, 6};
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int aim = array[i];

        while (i < j) {
            while (i < j && array[j] >= aim) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < aim) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }

        array[i] = aim;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }
}
