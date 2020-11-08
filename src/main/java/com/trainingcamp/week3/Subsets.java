package com.trainingcamp.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * @author jiaming
 */
public class Subsets {

    /*
     * 回溯算法的模板
     *
     * 1.记录走过的路径
     * 循环：
     *   2.做选择
     *   3.回溯
     *   4.撤销选择
     *
     *
     * */

    /**
     * 回溯算法解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    void back(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            back(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
