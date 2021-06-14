package com.trainingcamp.week8;

public class QuickSort3 extends BaseSort {

    public static void quickSort(int[] arr, int begin, int end) {
        //退出条件
        if (begin >= end) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        //pivot：选取的标杆下标；counter：小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, counter);
                counter++;
            }
        }
        if (pivot != counter) {
            swap(arr, pivot, counter);
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 1, 3};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
