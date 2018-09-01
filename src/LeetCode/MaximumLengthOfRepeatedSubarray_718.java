package LeetCode;

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
    class Solution {
        public int findLength(int[] A, int[] B) {
            if (A == null || B == null)
                return 0;
            int m = A.length, n = B.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++) {

                }
        }
    }
}
