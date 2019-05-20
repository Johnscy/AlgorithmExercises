package WrittenTest.ByteDance;
import java.util.*;

public class DFS1 {
    private static int M;
    private static int N;
    private static int maxQNow = 0;
    private static int P = 0;
    private static int Q = 0;
    private static int[][] hahaha= {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        M = Integer.valueOf(s[0]);
        N = Integer.valueOf(s[1]);
        int[][] matrix = new int[M][N];
        boolean[][] hasPassedBy = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.valueOf(str[j]);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!hasPassedBy[i][j] && matrix[i][j] == 1) {
                    DFS(matrix, hasPassedBy, i, j);
                    P++;
                    Q = maxQNow > Q ? maxQNow : Q;
                    maxQNow = 0;
                }
            }
        }
        System.out.println(P);
        System.out.println(Q);
    }
    private static void DFS(int[][] matrix,boolean[][] hasPassedBy,int i, int j){
        if (i >= M || i < 0 || j >= N || j < 0)
            return;
        else if (matrix[i][j] == 0 || hasPassedBy[i][j])
            return;
        else {
            maxQNow++;
            hasPassedBy[i][j] = true;
        }
        for (int k = 0; k < hahaha.length;k++){
            DFS(matrix,hasPassedBy,i + hahaha[k][0],j + hahaha[k][1]);
        }
    }
}
