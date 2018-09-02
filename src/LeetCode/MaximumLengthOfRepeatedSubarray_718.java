package LeetCode;
import java.util.Scanner;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthOfRepeatedSubarray_718 {
    //DP
    class Solution_DP_2D {
        public int findLength(int[] A, int[] B) {
            if (A == null || B == null)
                return 0;
            int m = A.length, n = B.length;
            int[][] dp = new int[m + 1][n + 1]; //dp[i][j] : 从1 - i和从1 - j的重复子数组长度
            int max = 0;
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(dp[i][j], max);
                    }
            return max;
        }
    }

    //DP
    class Solution_DP_1D {
        public int findLength(int[] A, int[] B) {
            if (A == null || B == null)
                return 0;
            int m = A.length, n = B.length;
            int[] dp = new int[n + 1];
            int max = 0;
            for (int i = 1; i <= m; i++)
                for (int j = n; j >= 1; j--){
                        dp[j] = A[i - 1] == B[j - 1] ? dp[j - 1] + 1 : 0;
                        max = Math.max(dp[j], max);
                    }
            return max;
        }
    }

    //test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strA = sc.nextLine().split(",");
        String[] strB = sc.nextLine().split(",");
        int[] A = new int[strA.length];
        int[] B = new int[strB.length];
        for (int i = 0; i < strA.length; i++)
            A[i] = Integer.valueOf(strA[i]);
        for (int i = 0; i < strB.length; i++)
            B[i] = Integer.valueOf(strB[i]);
        System.out.print(new MaximumLengthOfRepeatedSubarray_718().new Solution_DP_2D().findLength(A,B));
    }
}
