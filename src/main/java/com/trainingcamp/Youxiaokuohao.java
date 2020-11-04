package com.trainingcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class Youxiaokuohao {
    public boolean isValid1(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        //用hash表存储每一个符号
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !pairs.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
