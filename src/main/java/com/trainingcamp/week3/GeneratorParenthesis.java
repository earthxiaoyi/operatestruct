package com.trainingcamp.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * @author jiaming
 */
public class GeneratorParenthesis {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private void generate(int left, int right, int n, String s) {
        //退出条件
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        /**
         * 左边括号可以随时加，别超标
         * 左个数>右个数
         */
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        GeneratorParenthesis g = new GeneratorParenthesis();
        List<String> strings = g.generateParenthesis(3);
        System.out.println(strings);
    }

}
