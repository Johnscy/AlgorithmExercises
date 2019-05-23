package LeetCode;

/**
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * Example 1:
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 *
 * Example 2:
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:All 1s are either on the boundary or can reach the boundary.
 */
public class NumberOfEnclaves_1020 {
    //DFS 从边界的1开始dfs，遇到非边界的1则置为0，最后剩下的1的个数就是答案
    class Solution {
        private int res,M,N;

        public int numEnclaves(int[][] A) {
            if (A == null || A.length == 0 || A[0].length == 0)
                return 0;
            M = A.length;N = A[0].length;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == 1 && (i == 0 || i == M -1 || j == 0 || j == N -1)){
                        dfs(A,i,j);
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == 1)
                        res++;
                }
            }
            return res;
        }

        private void dfs(int[][] A,int x,int y){
            if (x >= 0 && x <= M - 1 && y >= 0 && y <= N -1 && A[x][y] == 1) {
                A[x][y] = 0;
                dfs(A, x + 1, y);
                dfs(A, x - 1, y);
                dfs(A, x, y + 1);
                dfs(A, x, y - 1);
            }
        }
    }
}
