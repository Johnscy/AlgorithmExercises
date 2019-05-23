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
        private int M, N, startX, startY, endX, endY;
        private int empty = 1, res = 0; //empty记录0的个数，多加1是因为要将起始点第一次置为-2
        public int uniquePathsIII(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;
            int M = grid.length, N = grid[0].length;
            this.M = M;this.N = N;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {      //找到起始点1才会开始DFS
                        startX = i;
                        startY = j;             //记录起始点坐标方便找到一个方案后重新继续寻找
                    }else if (grid[i][j] == 2){
                        endX = i;
                        endY = j;
                    }else if (grid[i][j] == 0)
                        empty++;
                }
            }
            dfs(grid,startX,startY);
            return res;
        }

        private void dfs(int[][] matrix,int i,int j){
            if (i < 0 || i >= M || j < 0 || j >= N || matrix[i][j] < 0)
                return;
            else if (i == endX && j == endY) {
                if (empty == 0)
                    res++;
                return;
            }
            else{
                matrix[i][j] = -2; //将走过的0和起始点1置为-2，之后遇到可以在第一个if直接return
                empty--;
            }
            for (int k = 0; k < moveOn.length; k++) {
                dfs(matrix,i + moveOn[k][0],j + moveOn[k][1]);
            }
            matrix[i][j] = 0; //重新置为0
            empty++;
        }
    }
}
