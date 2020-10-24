package com.sort;

/**
 * 堆排序
 *
 * @author jiaming
 */
public class Heap {

    private int[] p;
    private int n = 0;

    public Heap(int[] arrays) {
        this.p = arrays;
    }

    public void insert(int value){
        p[++n] = value;
        swim(n);
    }

    /**
     * 上浮
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 比较大小
     *
     * @param i
     * @param j
     * @return boolean
     */
    private boolean less(int i, int j) {
        return p[i] < p[j];
    }

    /**
     * 交换
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

}
