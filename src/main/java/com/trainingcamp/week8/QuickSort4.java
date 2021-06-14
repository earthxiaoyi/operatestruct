package com.trainingcamp.week8;

/**
 * @author jiaming
 */
public class QuickSort4 extends BaseSort {

    /**
     * 快速排序
     *
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort(int[] arr, int begin, int end) {
        //递归退出条件
        if (begin >= end) {
            return;
        }
        //找到中间节点
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    /**
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int partition(int[] arr, int begin, int end) {
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

}
