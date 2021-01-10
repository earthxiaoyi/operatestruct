package com.trainingcamp;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 题目数据保证答案肯定是一个 32 位的整数。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 *
 * @author jiaming
 */
public class NumDecodings {
    public int numDecodings(String s) {
        Map<Integer, Integer> results = new HashMap<>();
        return getAns(s, 0, results);
    }

    private int getAns(String s, int begin, Map<Integer, Integer> results) {
        if (begin == s.length()) {
            return 1;
        }
        if (s.charAt(begin) == '0') {
            return 0;
        }
        //判断之前是否计算过
        Integer orDefault = results.getOrDefault(begin, -1);
        if (orDefault != -1) {
            return orDefault;
        }
        int ans1 = getAns(s, begin + 1, results);
        int ans2 = 0;
        if (begin < s.length() - 1) {
            int ten = (s.charAt(begin) - '0') * 10;
            int one = s.charAt(begin + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, begin + 2, results);
            }
        }
        results.put(begin, ans1 + ans2);
        return ans1 + ans2;
    }
}
