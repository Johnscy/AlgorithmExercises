package LeetCode;
import java.util.*;

/**
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum_416 {
    //DP，0-1背包问题
    class Solution_2D {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;
            int sum = 0;
            for (int e : nums)
                sum += e;
            if ((sum & 1) == 1)
                return false;
            sum /= 2;
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            for (int i = 1; i <= n; i++)
                dp[i][0] = true;
            for (int i = 1; i <= sum; i++)
                dp[0][i] = false;
            dp[0][0] = true;
            for (int i = 1; i <= n; i++)
                for (int j = sum; j >= 1; j--)
                    dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : false);
            return dp[n][sum];
        }
    }

    //
    class Solution_1D {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;
            int sum = 0;
            for (int e : nums)
                sum += e;
            if ((sum & 1) == 1)
                return false;
            sum /= 2;
            int n = nums.length;
            boolean[] dp = new boolean[sum + 1];
            Arrays.fill(dp,false);
            dp[0] = true;
            for (int e : nums)
                for (int i = sum; i > 0; i--)
                    if (i >= e)
                        dp[i] = dp[i] || dp[i - e];
            return dp[sum];
        }
    }

}
