package com.trainingcamp.week8;

/**
 * 冒泡排序
 *
 * @author jiaming
 */
public class BubbleSort extends BaseSort{

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 3, 10, 21, 20};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
