package com.leetcode;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
public class LeetCode74 {

    /**
     * 这道题可以用标准的二分法查找解
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //二维数组的行数 row
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        //二维数组中的列数 col
        int n = matrix[0].length;
        //二维数组的长度为：m*n-1
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            //定位二维数组的行数:   row = idx // n
            //定位二维数组中的列数: col = idx % n
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (pivotElement == target) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }

}
