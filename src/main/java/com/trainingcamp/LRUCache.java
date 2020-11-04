package com.trainingcamp;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 */
/*
    示例：
        LRUCache cache = new LRUCache( 2 *//* 缓存容量 *//* );

        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);       // 返回  1
        cache.put(3,3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4,4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
        */

/**
 * @author jiaming
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private DoubleList doubleList;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.doubleList = new DoubleList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).val;
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
        } else {
            if (capacity == doubleList.size()) {
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
        }
        doubleList.addFirst(node);
        map.put(key, node);
    }

    /**
     * 双链表
     */
    private static class DoubleList {

        Node first, last;

        private int count;

        private boolean isEmpty() {
            return first == null;
        }

        /**
         * 在链表头部添加节点 x，时间 O(1)
         */
        public void addFirst(Node x) {
            if (isEmpty()) {
                last = x;
            } else {
                first.prev = x;
            }
            x.next = first;
            first = x;
            ++count;
        }

        public void addLast(Node x) {
            if (isEmpty()) {
                first = x;
            } else {
                last.next = x;
                x.prev = last;
            }
            last = x;
            ++count;
        }

        /**
         * 删除链表中的 x 节点（x 一定存在）
         * 由于是双链表且给的是目标 Node 节点，时间 O(1)
         *
         * @param x
         */
        public void remove(Node x) {
            Node node = find(x.key);
            //如果这个结点是first，那么就把它的next作为新的first
            if (node.key == first.key) {
                first = node.next;
            } else {
                node.prev.next = node.next;
            }
            //如果这个结点是last，那么就把它的privious结点置为last
            if (node.key == last.key) {
                last = last.prev;
            } else {
                node.next.prev = node.prev;
            }
            --count;
        }

        private Node find(int key) {
            Node node = first;
            while (node.key != key) {
                node = node.next;
                if (node == null) {
                    return null;
                }
            }
            return node;
        }

        /**
         * 删除链表中最后一个节点，并返回该节点，时间 O(1)
         */
        public Node removeLast() {
            Node node = last;
            if (node.prev == null) {
                first = null;
            } else {
                last.prev.next = null;
            }
            last = last.prev;
            --count;
            return node;
        }

        /**
         * 返回链表长度，时间 O(1)
         *
         * @return
         */
        public int size() {
            return count;
        }
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

    /*public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(" "+lruCache.get(1));
        System.out.println(" "+lruCache.get(2));
        System.out.println(" "+lruCache.get(3));
        System.out.println(" "+lruCache.get(4));
    }*/
}