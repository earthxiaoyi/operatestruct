package com.trainingcamp.week4;

import com.trainingcamp.week3.BuildTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 深度优先搜索-递归版代码模板
 *
 * @author jiaming
 */
public class DFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        travel(root, 0, res);
        return res;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, res);
        }
        if (root.right != null) {
            travel(root.right, level + 1, res);
        }
    }
}
