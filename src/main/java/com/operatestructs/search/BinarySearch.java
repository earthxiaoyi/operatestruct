package com.operatestructs.search;

/**
 * Created by jiaming on 2019/8/3.
 */
public class BinarySearch {

    private int[] nums;
    private int n;

    public BinarySearch(int[] nums, int n) {
        this.nums = nums;
        this.n = n;
    }

    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        int n = nums.length;
        BinarySearch binarySearch = new BinarySearch(nums, n);
        binarySearch.find_rotate_index(0, n - 1);

        int bsearch = binarySearch.bsearch(nums, nums.length, 1);
        System.out.println(bsearch);
    }

    /**
     * 简单二分查找,假设数组中的数据从小到大排序
     *
     * @param nums  数组
     * @param n     数组长度
     * @param value 需要查找的值
     * @return 与value值相等的下标
     */
    public int bsearch(int[] nums, int n, int value) {
        if (nums.length == 0) {
            throw new RuntimeException("nums is not empty!");
        }
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找变体一：查找第一个值等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public int bsearch_1(int[] nums, int n, int value) {

        return -1;
    }

    /**
     * 二分查找变体二：查找最后一个值等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public int bsearch_2(int[] nums, int n, int value) {

        return -1;
    }
    /**
     * 二分查找变体三：查找第一个大于等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public int bsearch_3(int[] nums, int n, int value) {

        return -1;
    }

    /**
     * 二分查找变体四：查找最后一个小于等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public int bsearch_4(int[] nums, int n, int value) {

        return -1;
    }

}
