package com.trainingcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int num : nums1) {
            int count = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, count);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = hashMap.getOrDefault(num, 0);
            if (count > 0) {
                list.add(num);
                count--;
                if (count > 0) {
                    hashMap.put(num, count);
                } else {
                    hashMap.remove(num);
                }
            }
        }
        int[] merge = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            merge[i] = list.get(i);
        }
        return merge;
    }
}


