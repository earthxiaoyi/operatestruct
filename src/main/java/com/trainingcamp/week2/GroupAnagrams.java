package com.trainingcamp.week2;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            //放入map->list中
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
