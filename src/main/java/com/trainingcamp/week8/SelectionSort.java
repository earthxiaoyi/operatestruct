package com.trainingcamp.week8;

/**
 * 选择排序
 *
 * @author jiaming
 */
public class SelectionSort extends BaseSort {

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 222, 3, 4, 1, 23, 1, 23, 12, 3, 4,
                4, 5, 5, 3, 4, 76, 678, 23, 23, 4};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
