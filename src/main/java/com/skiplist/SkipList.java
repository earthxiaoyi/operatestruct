package com.skiplist;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典跳表的实现
 *
 * @author jiaming
 */
public class SkipList<K extends Comparable<K>, V> {

    /**
     * <0.5继续循环，>=0.5停止
     */
    private static final double PROBABILITY = 0.5;

    private SkipListNode<K, V> head;
    private int size;
    private int maxLevel;

    public SkipList() {
        this.head = new SkipListNode<K, V>(null, null);
        this.head.nextNodes.add(null);
        this.size = 0;
        this.maxLevel = 0;
    }

    /**
     * 从最高层一路找下去，找到第0层<key的最右节点
     *
     * @param key
     * @return
     */
    private SkipListNode<K, V> mostRightLessNodeInTree(K key) {
        if (key == null) {
            return null;
        }
        int level = maxLevel;
        SkipListNode<K, V> cur = head;
        while (level >= 0) {
            cur = mostRightLessNodeInLevel(cur, level--, key);
        }
        return cur;
    }

    /**
     * 在level层中向右移动，现在来到的节点是cur，来到了cur的level层，
     * 在level层上，找到<key最后一个节点并返回
     *
     * @param cur
     * @param level
     * @param key
     * @return
     */
    private SkipListNode<K, V> mostRightLessNodeInLevel(SkipListNode<K, V> cur, int level, K key) {
        if (key == null) {
            return null;
        }
        SkipListNode<K, V> next = cur.nextNodes.get(level);
        while (next != null && next.isKeyLess(key)) {
            cur = next;
            next = next.nextNodes.get(level);
        }
        return cur;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        //从0层开始找到最右一个<key的node
        SkipListNode<K, V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> find = less.nextNodes.get(0);
        return find != null && find.isKeyEquals(key);
    }

    /**
     * 插入一个节点
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        //从0层开始找到最右一个<key的node
        SkipListNode<K, V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> find = less.nextNodes.get(0);
        if (find != null && find.isKeyEquals(key)) {
            find.value = value;
        } else {
            size++;
            //随机确定新增节点层数
            int newNodeLevel = 0;
            while (Math.random() < PROBABILITY) {
                newNodeLevel++;
            }
            //如果新节点层高大于maxLevel，则maxLevel要和新节点层高一致
            while (newNodeLevel > maxLevel) {
                head.nextNodes.add(null);
                maxLevel++;
            }
            SkipListNode<K, V> newNode = new SkipListNode<>(key, value);
            //增加新节点层数
            for (int i = 0; i <= newNodeLevel; i++) {
                newNode.nextNodes.add(null);
            }
            int level = maxLevel;
            SkipListNode<K, V> pre = head;
            while (level >= 0) {
                pre = mostRightLessNodeInLevel(pre, level, key);
                if (level <= newNodeLevel) {
                    newNode.nextNodes.set(level, pre.nextNodes.get(level));
                    pre.nextNodes.set(level, newNode);
                }
                level--;
            }
        }
    }

    public void remove(K key) {
        if (containsKey(key)) {
            size--;
            int level = maxLevel;
            SkipListNode<K, V> pre = head;
            while (level >= 0) {
                pre = mostRightLessNodeInLevel(pre, level, key);
                SkipListNode<K, V> next = pre.nextNodes.get(level);
                if (next != null && next.isKeyEquals(key)) {
                    pre.nextNodes.set(level, next.nextNodes.get(level));
                }
                // 在level层只有一个节点了，就是默认节点head
                if (level != 0 && pre == head && pre.nextNodes.get(level) == null) {
                    head.nextNodes.remove(level);
                    maxLevel--;
                }
                level--;
            }
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        SkipListNode<K, V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> next = less.nextNodes.get(0);
        return (next != null && next.isKeyEquals(key)) ? next.value : null;
    }

    public int size() {
        return size;
    }

    public K firstKey() {
        return head.nextNodes.get(0) != null ? head.nextNodes.get(0).key : null;
    }

    public K lastKey() {
        int level = maxLevel;
        SkipListNode<K, V> cur = head;
        while (level >= 0) {
            SkipListNode<K, V> next = cur.nextNodes.get(level);
            while (next != null) {
                cur = next;
                next = cur.nextNodes.get(level);
            }
            level--;
        }
        return cur.key;
    }

    public K ceilingKey(K key) {
        if (key == null) {
            return null;
        }
        SkipListNode<K, V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> next = less.nextNodes.get(0);
        return next != null ? next.key : null;
    }

    public K floorKey(K key) {
        if (key == null) {
            return null;
        }
        SkipListNode<K, V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> next = less.nextNodes.get(0);
        return next != null && next.isKeyEquals(key) ? next.key : less.key;
    }

    public static class SkipListNode<K extends Comparable<K>, V> {

        public K key;
        public V value;
        /**
         * 下一层节点node list
         */
        public List<SkipListNode<K, V>> nextNodes;

        public SkipListNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.nextNodes = new ArrayList<>();
        }

        /**
         * 判断key大小
         *
         * @param otherKey
         * @return boolean
         */
        public boolean isKeyLess(K otherKey) {
            return otherKey != null && (key == null || key.compareTo(otherKey) < 0);
        }

        /**
         * 判断key是否相等
         *
         * @param otherKey
         * @return boolean
         */
        public boolean isKeyEquals(K otherKey) {
            return (otherKey == null && key == null) ||
                    (otherKey != null && key != null && otherKey.compareTo(key) == 0);
        }

    }

    public static void main(String[] args) {
        SkipList<String, String> skipList = new SkipList();
        skipList.put("a", "1");
        skipList.put("b", "2");
        skipList.put("c", "3");
        skipList.put("d", "4");

        String a = skipList.get("a");
        System.out.println(a);
        skipList.remove("b");
        System.out.println(skipList.get("b"));

    }

}
