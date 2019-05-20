package LeetCode;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Example 1:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 * Example 2:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *
 * Example 3:
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.Note that the starting and ending square can be anywhere in the grid.
 */
public class UniquePathsIII_980 {
    //DFS
    class Solution {
        private final int[][] moveOn = {{1,0},{-1,0},{0,1},{0,-1}};
        private int M;
        private int N;
        private int res;
        public int uniquePathsIII(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;
            int M = grid.length, N = grid[0].length;
            this.M = M;this.N = N;
            boolean[][] hasWalkedOver = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {      //找到起始点1才会开始DFS
                        DFS(grid,hasWalkedOver,i,j);
                    }

                }
            }
            return res;
        }

        private void DFS(int[][] matrix,boolean[][] hasWalkedOver,int i,int j){
            if (i < 0 || i >= M || j < 0 || j >= N)
                return;
            else if (matrix[i][j] == -1)
                return;
            else if (matrix[i][j] == 2) {
                res++;
                return;
            }
            else
                hasWalkedOver[i][j] = true;
            for (int k = 0; k < moveOn.length; k++) {
                DFS(matrix,hasWalkedOver,i+ moveOn[k][0],j + moveOn[k][1]);
            }
        }
    }
}
