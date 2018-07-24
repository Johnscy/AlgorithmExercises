package Target_To_Offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
    //回溯法
    public class Solution_BackTracking {
        private final  int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};   //上下左右的坐标变化
        private int rows;   //给处理回溯的方法用的，不用麻烦每次多传这俩参数了
        private int cols;   //给处理回溯的方法用的
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
            if (matrix == null || rows <= 0 || cols <= 0 || str == null || matrix.length == 0 || str.length == 0 || str.length > matrix.length)
                return false;
            this.rows = rows;
            this.cols = cols;
            boolean[][] marked = new boolean[rows][cols];   //标记格子是否走过
            char[][] matrix_2d = new char[rows][cols];      //将一维数组转化为二维
            for (int i = 0, index = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix_2d[i][j] = matrix[index++];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (backtracking(matrix_2d,str,marked,0,i,j))
                        return true;
            return false;
        }

        private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c){
            if (pathLen == str.length)
                return true;
            if (r < 0 || r>= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c])
                return false;
            marked[r][c] = true;    //标记此位置走过
            for (int[] nextStep : next)
                if (backtracking(matrix,str,marked,pathLen + 1,r + nextStep[0],c + nextStep[1]))
                    return true;
            marked[r][c] = false;   //回退
            return false;
        }
    }
}
