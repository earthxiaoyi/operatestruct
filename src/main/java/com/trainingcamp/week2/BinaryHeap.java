package com.trainingcamp.week2;

import java.util.Arrays;

/**
 * 二叉堆
 * <p>
 * 假设第一个元素在数组的索引为0的话，则父节点和子节点的位置关系如下：
 * <p>
 * 1）索引为i的左孩子节点下标为：（2*i）+1
 * 2）索引为i的右孩子节点下标为：（2*i）+2
 * 3）索引为i的父节点下标为：   （i-1）/2
 *
 * @author jiaming
 */
public class BinaryHeap {

    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    /**
     * 初始化二叉堆数组
     *
     * @param capacity
     */
    public BinaryHeap(int capacity) {
        this.heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) {
        if (isFull()) {
            return;
        }
        heap[heapSize] = x;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    private void heapifyUp(int i) {
        int value = heap[i];
        //判断value是否大于他的父节点
        while (i > 0 && (value > heap[parent(i)])) {
            //父节点元素挪开
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = value;
    }

    private void heapifyDown(int i) {
        int tailValue = heap[heapSize - 1];
        heap[0] = tailValue;
        heapSize--;

    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void delete(int x) {

    }


}
