package com.trainingcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 *
 * @author jiaming
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        //1、hash表的方式去解
        if (nums1.length < nums2.length) {
            return handler(nums1, nums2);
        } else {
            return handler(nums2, nums1);
        }
    }

    private int[] handler(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> res = map.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        int[] ints = res.stream().mapToInt(v -> v).toArray();
        return ints;
    }

}
