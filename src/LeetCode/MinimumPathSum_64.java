package LeetCode;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum_64 {
    //DP
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j !=0)
                        grid[i][j] += grid[i][j - 1];
                    else if (i != 0 && j == 0)
                        grid[i][j] += grid[i - 1][j];
                    else if (i != 0 && j != 0)
                        grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                }
            return grid[m - 1][n - 1];
        }
    }
}
