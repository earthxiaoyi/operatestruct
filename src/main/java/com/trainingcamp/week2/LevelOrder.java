package com.trainingcamp.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 *  
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 通过次数32,322提交次数48,235
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 *
 * @author jiaming
 */
public class LevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 利用queue的方式遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}
