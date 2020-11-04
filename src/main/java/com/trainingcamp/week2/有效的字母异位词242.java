package com.trainingcamp.week2;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 */
public class 有效的字母异位词242 {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer count = hashMap.get(c);
            if (count == null) {
                return false;
            } else if (count > 1) {
                hashMap.put(c, count - 1);
            } else {
                hashMap.remove(c);
            }
        }
        return hashMap.isEmpty();
    }

}
