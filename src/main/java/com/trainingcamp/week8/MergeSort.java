package com.trainingcamp.week8;

/**
 * 归并排序
 *
 * @author jiaming
 */
public class MergeSort extends BaseSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        //(left + right) / 2
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 222, 3, 4, 1, 23, 1, 23, 12, 3, 4,
                4, 5, 5, 3, 4, 76, 678, 23, 23, 4};
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
