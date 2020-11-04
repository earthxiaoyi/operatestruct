package com.trainingcamp.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的前、中、后序遍历
 *
 * @author jiaming
 */
public class TreeInOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //middleInOrder(root, res);
        //preInOrder(root, res);
        //postInOrder(root,res);
        return res;
    }

    /**
     * 后续遍历
     *
     * @param root
     * @param res
     */
    private void postInOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postInOrder(root.left, res);
        postInOrder(root.right, res);
        res.add(root.val);
    }

    /**
     * 前序遍历
     *
     * @param root
     * @param res
     */
    private void preInOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preInOrder(root.left, res);
        preInOrder(root.right, res);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param res
     */
    private void middleInOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        middleInOrder(root.left, res);
        res.add(root.val);
        middleInOrder(root.right, res);
    }


}

