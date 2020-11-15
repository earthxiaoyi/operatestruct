package com.trainingcamp.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaming
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<>(k);
        dfs(1, n, k, queue, res);
        return res;
    }

    private void dfs(int begin, int n, int k, Deque<Integer> queue, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(queue));
            return;
        }
        //递归终止条件
        if (begin > n - k + 1) {
            return;
        }
        dfs(begin + 1, n, k, queue, res);
        queue.addLast(begin);
        // 不选当前考虑的数 begin，直接递归到下一层
        dfs(begin + 1, n, k - 1, queue, res);
        queue.removeLast();
    }

}
