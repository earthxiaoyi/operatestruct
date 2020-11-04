package com.trainingcamp.week2;

import java.util.Comparator;

/**
 * 二叉搜索树
 *
 * @author jiaming
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private BinaryNode root;

    /**
     * 二叉树节点定义对象
     */
    private class BinaryNode<E> {

        E element;

        BinaryNode<E> left, right;

        public BinaryNode(E e) {
            this.element = e;
        }

        public BinaryNode(E e, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = e;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E e) {
        return false;
    }

    public E findMax() {
        return null;
    }

    public E findMin() {
        return null;
    }

    public void insert(E e) {

    }

    public E remove(E e) {

        return null;
    }

    private E remove(E e, BinaryNode<E> t) {

        return null;
    }

    private E insert(E e, BinaryNode<E> t) {

        return null;
    }

    private E contains(E e, BinaryNode<E> t) {
        if (t == null) {
            return null;
        }
        int cmp = e.compareTo(t.element);
        if (cmp > 0) {

        } else if (cmp < 0) {

        } else {
            return t.element;
        }
        return null;
    }

    private void printTree(BinaryNode<E> t) {

    }

}
