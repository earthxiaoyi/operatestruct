package com.trainingcamp.week4;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * @author jiaming
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int right = matrix[i].length - 1;
            int left = 0;
            int mid;
            while (left <= right) {
                mid = (right - left) / 2 + left;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

}
