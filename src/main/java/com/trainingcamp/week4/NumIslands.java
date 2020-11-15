package com.trainingcamp.week4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 *
 * @author jiaming
 */
public class NumIslands {

    /**
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        //判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //二维数组长度
        int nr = grid.length;
        //二维数组宽度
        int nc = grid[0].length;
        //岛屿数量
        int numsIslands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numsIslands;
                    dfs(grid, r, c);
                }
            }
        }
        return numsIslands;
    }

    /**
     * 深度优先搜索
     *
     * @param grid
     * @param r    长度
     * @param c    宽度
     */
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 广度优先搜索
     */
    private int bfs(char[][] grid) {
        //判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //二维数组长度
        int nr = grid.length;
        //二维数组宽度
        int nc = grid[0].length;
        //岛屿数量
        int numsIslands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numsIslands;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        Integer id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return numsIslands;
    }

}
