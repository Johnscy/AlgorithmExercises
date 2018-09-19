package LeetCode;
import java.util.*;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit
 */
public class NumberOfLongestIncreasingSubsequence_673 {
    //dp
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            if (nums.length == 1)
                return 1;
            int n = nums.length;
            int res = 0, max = 1;
            int[] dp = new int[n];
            int[] count = new int[n];
            Arrays.fill(dp,1);
            for (int i = 0; i < n; i++) {
                int cnt = 1;
                for (int j = 0; j < i; j++)
                    if (nums[i] > nums[j]) {
                        if (1 + dp[j] > dp[i]) {
                            cnt = count[j];
                            dp[i] = 1 + dp[j];
                        } else if (1 + dp[j] == dp[i]) {
                            cnt += count[j];
                        }
                    }
                count[i] = cnt;
                if (dp[i] > max) {
                    res = cnt;
                    max = dp[i];
                } else if (dp[i] == max) {
                    res += cnt;
                }
            }
            return res;
        }
    }
}
