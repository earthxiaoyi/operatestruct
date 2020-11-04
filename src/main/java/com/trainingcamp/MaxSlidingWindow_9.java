package com.trainingcamp;

import java.util.*;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 *
 * @author jiaming
 */
public class MaxSlidingWindow_9 {

    /**
     * 单调队列法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        //未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res.add(deque.peekFirst());
        //形成窗口后
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res.add(deque.peekFirst());
        }
        return res.stream().mapToInt(value -> value).toArray();
    }



}
