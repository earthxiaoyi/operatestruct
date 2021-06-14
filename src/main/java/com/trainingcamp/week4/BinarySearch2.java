package com.trainingcamp.week4;

/**
 * @author jiaming
 */
public class BinarySearch2 {

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{111,222,4444,2,1,5};
        int i = binarySearch(array, 5);
        System.out.println(i);
    }

}
