package com.trainingcamp;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 */
public class FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                return nums[i];
            } else {
                hash.add(nums[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 11, 4, 11};
        System.out.println(findRepeatNumber(arr));
    }
}
