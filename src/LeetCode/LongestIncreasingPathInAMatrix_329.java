package LeetCode;

import edu.princeton.cs.algs4.In;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathInAMatrix_329 {
    //DP + BFS
    class Solution {
        private int[] dx = {-1,1,0,0};
        private int[] dy = {0,0,1,-1};
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length, n = matrix[0].length;
            if (m == 1 && n == 1)
                return 1;
            boolean[][] visited = new boolean[m][n];    //记录(x,y)是否被访问过
            int[][] dp = new int[m][n];                 //表明在(x,y)可以得到的最长上升路径的长度
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res,search(matrix,visited,dp,i,j));
                }
            }
            return res;
        }
        private int search(int[][] matrix, boolean[][] visited, int[][] dp, int x, int y){
            if (visited[x][y])
                return dp[x][y];
            dp[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];
                if (curX >= 0 && curX <= matrix.length && curY >= 0 && curY <= matrix[0].length && matrix[curX][curY] < matrix[x][y])
                    dp[x][y] = Math.max(dp[x][y],search(matrix,visited,dp,curX,curY) + 1);
            }
            visited[x][y] = true;
            return dp[x][y];
        }
    }
}
