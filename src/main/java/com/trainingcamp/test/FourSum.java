package com.trainingcamp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * 参考题解：
 * https://leetcode-cn.com/problems/4sum/solution/mei-kan-dao-ji-ge-hui-su-de-ti-jie-na-wo-lai-xie-y/
 *
 * @author jiaming
 */
public class FourSum {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int cur = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return res;
        }
        //排序
        Arrays.sort(nums);
        dfs(nums, target, 0);
        return res;
    }

    private void dfs(int[] nums, int target, int begin) {
        //递归退出的条件
        if (list.size() == 4) {
            if (cur == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            //nums数组余下的数筹不够4个数，返回
            if (nums.length - i < 4 - list.size()) {
                return;
            }
            //从第二轮循环开始，如果数组中当前数字和前一个相同，则剪掉（进行下一次循环，这条的任务就是去重）
            if (i != begin && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[i + 1] > target) {
                return;
            }
            if (i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[nums.length - 1] < target) {
                continue;
            }
            cur += nums[i];
            list.add(nums[i]);
            dfs(nums, target, i + 1);
            list.remove(list.size() - 1);
            cur -= nums[i];
        }
    }

}