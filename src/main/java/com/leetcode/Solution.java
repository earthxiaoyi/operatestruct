package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaming on 2018/11/24.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            int completion = target-nums[i];
            if(map.containsKey(completion) && map.get(completion)!=i){
                return new int[]{i,map.get(completion)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(ints[0]+","+ints[1]);
    }

}
