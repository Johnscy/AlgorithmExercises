package LeetCode;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 */
public class MaxAreaOfIsland_695 {
    //DFS
    class Solution {
        private final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        private int m;  //矩阵长
        private int n;  //矩阵宽
        private int maxArea = 0;
        private int maxAreaNow = 0;
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            m = grid.length;
            n = grid[0].length;
            boolean[][] hasUsed = new boolean[m][n];
            for (int i = 0;i < m;i++)
                for (int j = 0; j < n; j++) {
                    if (!hasUsed[i][j] && grid[i][j] == 1){
                        dFS(grid,hasUsed,i,j);
                        maxArea = maxArea > maxAreaNow ? maxArea : maxAreaNow;
                        maxAreaNow = 0;
                    }
                }
            return maxArea;
        }
        private void dFS(int[][] matrix, boolean[][] hasUsed, int i, int j){
            if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0 || hasUsed[i][j])
                return;
            else{
                maxAreaNow++;
                hasUsed[i][j] = true;
            }
            for (int k = 0; k < 4; k++)
                dFS(matrix,hasUsed,i + directions[k][0],j + directions[k][1]);
        }
    }
}
