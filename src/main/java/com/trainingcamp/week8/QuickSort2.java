package com.trainingcamp.week8;

public class QuickSort2 extends BaseSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11112, 1, 222, 3, 4, 1, 23, 1, 23, 12, 3, 4,
                4, 5, 5, 3, 4, 76, 678, 23, 23, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
