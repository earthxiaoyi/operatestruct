package com.trainingcamp.week2;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 *
 * @author jiaming
 */
public class TopKFrequent {

    /**
     * 计算出现频率最高的
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num,1);
            }
            //countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return countMap.get(a) - countMap.get(b);
            }
        });
        // 取出最小堆中的元素

        for (Integer key : countMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(key);
            } else if (countMap.get(key) > countMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.offer(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll());
        }
        return res.stream().mapToInt(v -> v).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        int[] ints = topKFrequent(arr, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


}
