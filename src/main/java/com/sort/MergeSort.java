package com.sort;

/**
 * 归并排序
 *
 * @author jiaming
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr, int l, int h) {
        if (l == h) {
            return new int[]{arr[l]};
        }
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(arr, l, mid);
        int[] rightArr = mergeSort(arr, mid + 1, h);
        int[] newArr = new int[leftArr.length + rightArr.length];
        int n = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newArr[n++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newArr[n++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newArr[n++] = rightArr[j++];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3};
        int[] newArr = mergeSort(arr, 0, arr.length - 1);
        for (int i : newArr) {
            System.out.println(i);
        }

    }

}
