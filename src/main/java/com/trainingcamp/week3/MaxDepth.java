package com.trainingcamp.week3;

/**
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 * @author jiaming
 */
public class MaxDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        int maxDepth = calMaxDepth(root, 0);

        return maxDepth;
    }

    private int calMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = calMaxDepth(root.left, depth + 1);
        int right = calMaxDepth(root.right, depth + 1);
        return Math.max(left, right);
    }

}
