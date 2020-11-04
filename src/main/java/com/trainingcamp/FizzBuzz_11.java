package com.trainingcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 *
 * @author jiaming
 */
public class FizzBuzz_11 {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean b1 = i % 3 == 0;
            boolean b2 = i % 5 == 0;
            if (b1 && b2) {
                res.add("FizzBuzz");
            } else if (b1) {
                res.add("Fizz");
            } else if (b2) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

}
