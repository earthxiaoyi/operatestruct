package com.trainingcamp;

/**
 * 双链表
 */
public class DoubleList {
    /**
     * 在链表头部添加节点 x，时间 O(1)
     */
    public void addFirst(Node x) {

    }

    /**
     * 删除链表中的 x 节点（x 一定存在）
     * 由于是双链表且给的是目标 Node 节点，时间 O(1)
     *
     * @param x
     */
    public void remove(Node x) {

    }

    /**
     * 删除链表中最后一个节点，并返回该节点，时间 O(1)
     */
    public Node removeLast() {

        return null;
    }

    /**
     * 返回链表长度，时间 O(1)
     *
     * @return
     */
    public int size() {
        return 1;
    }

    /**
     * 双链表结构
     */
    private static class Node {

        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

}
