package com.trainingcamp.week8;

/**
 * 经典快排
 *
 * @author jiaming
 */
public class QuickSort extends BaseSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        //pivot:标杆的位置 counter:小于标杆的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, counter);
                counter++;
            }
        }
        swap(arr, pivot, counter);
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 222, 3, 4, 1, 23, 1, 23, 12, 3, 4,
                4, 5, 5, 3, 4, 76, 678, 23, 23, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
