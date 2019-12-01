package com.sort;

/**
 * Created by jiaming on 2019/2/17.
 */
public class Sort {

    public static void main(String[] args) {

        int[] array = new int[]{5, 3, 1, 77, 2, 90, 100, 33, 22};

        Sort sort = new Sort();

        //sort.insertionSort(array);

        sort.quickSort(array);
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public void quickSort(int[] array) {
        quickSortC(array,0,array.length-1);
        //打印
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]+",");
        }
    }

    private void quickSortC(int[] array, int p, int r) {
        //如果p>=r则退出递归
        if (p >= r) {
            return;
        }
        int q = partition(array, p, r);
        quickSortC(array, p, q - 1);
        quickSortC(array, q + 1, r);
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;//已分区区间下标
        for (int j = p; j <= r-1; j++) {
            if (array[j] < pivot) {
                //交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[r];
        array[r] = temp;
        return i;
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void buddleSort(int[] array) {

    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void insertionSort(int[] array) {

        int n = array.length;

        for (int i = 1; i < n; ++i) {

            int value = array[i];

            int j = i - 1;
            //选择并移动元素
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //插入元素
            array[j + 1] = value;
        }

        //打印
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

}
