package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ids = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (val + nums[j] == target) {
                    ids[0] = i;
                    ids[1] = j;
                }
            }
        }
        return ids;
    }

    public static int[] towSum2(int[] nums, int target) {
        //[2, 7, 11, 15]
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        towSum2(arr, 9);
    }


}
