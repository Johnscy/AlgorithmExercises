package Target_To_Offer;

import java.util.Stack;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    //DFS，递归
    public class Solution_Recursion {
        private final  int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};   //上下左右的坐标变化
        private int count = 0;  //记录到达的格子数
        private int rows;       //给处理回溯的方法用的，不用麻烦每次多传这俩参数了
        private int cols;       //同上
        private int threshold;  //同上
        private int[][] digitSum;//存储每个格子的坐标数位和
        public int movingCount(int threshold, int rows, int cols) {
            if (rows <= 0 || cols <= 0 || threshold < 0)
                return 0;
            this.rows = rows;
            this.cols = cols;
            this.threshold = threshold;
            boolean[][] marked = new boolean[rows][cols];   //标记格子是否能够进入
            initDigitSum(); //计算出每个格子的坐标数位和
            DFS(marked,0,0);
            return count;
        }
        private void DFS(boolean[][] marked, int r, int c){
            if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
                return;
            marked[r][c] = true;
            if (digitSum[r][c] > threshold)
                return;
            count++;
            for (int[] nextStep : next)
                 DFS(marked,r + nextStep[0],c + nextStep[1]);
        }
        private void initDigitSum(){
            int[] digitSumOne = new int[Math.max(rows,cols)];
            for (int i = 0; i < digitSumOne.length; i++) {
                int n = i;
                while (n > 0){
                    digitSumOne[i] += n % 10;
                    n /= 10;
                }
            }
            digitSum = new int[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
        }
    }

    //DFS，非递归，栈
    public class Solution {
        private final  int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};   //上下左右的坐标变化
        private int count = 0;  //记录到达的格子数
        private int rows;       //给处理回溯的方法用的，不用麻烦每次多传这俩参数了
        private int cols;       //同上
        private int threshold;  //同上
        private int[][] digitSum;//存储每个格子的坐标数位和
        public int movingCount(int threshold, int rows, int cols) {
            if (rows <= 0 || cols <= 0 || threshold < 0)
                return 0;
            this.rows = rows;
            this.cols = cols;
            this.threshold = threshold;
            boolean[][] marked = new boolean[rows][cols];   //标记格子是否能够进入
            Stack<Integer> stack = new Stack<>();
            initDigitSum();     //计算出每个格子的坐标数位和
            stack.push(0);
            marked[0][0] = true;
            int cur, x, y;            //将矩阵变为一维数组后的索引！！！！和矩阵每个格子的坐标
            while (!stack.isEmpty()){
                cur = stack.pop();
                count++;
                x = cur % cols;
                y = cur / cols;
                for(int[] nextStep : next){
                    x += nextStep[0];
                    y += nextStep[1];
                     if(digitSum[x][y] <= threshold && x >= 0 && y >= 0 && !marked[x][y]) {
                         stack.push(x + y * cols);
                         marked[x][y] = true;
                     }
                }
            }
            return count;
        }

        private void initDigitSum(){
            int[] digitSumOne = new int[Math.max(rows,cols)];
            for (int i = 0; i < digitSumOne.length; i++) {
                int n = i;
                while (n > 0){
                    digitSumOne[i] += n % 10;
                    n /= 10;
                }
            }
            digitSum = new int[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
        }
    }
}
