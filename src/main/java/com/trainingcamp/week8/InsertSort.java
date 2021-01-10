package com.trainingcamp.week8;

/**
 * 插入排序
 *
 * @author jiaming
 */
public class InsertSort extends BaseSort {

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 222, 3, 4, 1, 23, 1, 23, 12, 3, 4,
                4, 5, 5, 3, 4, 76, 678, 23, 23, 4};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}