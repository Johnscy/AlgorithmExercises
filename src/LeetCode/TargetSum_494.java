package LeetCode;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSum_494 {
    //DP
    //数组中的每个数选择自己的符号，P：正数  N：负数
    // sum(P) - sum(N) = target
    // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //  2 * sum(P) = target + sum(nums)
    class Solution_DPBest {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0)
                return 0;
            int sum = 0;
            for (int e : nums) sum += e;
            if (sum < S || S < -sum || (S + sum) % 2 > 0)
                return 0;
            return subsetSum(nums,(sum + S) >>> 1); //只需计算正数的情况就行
        }
        private int subsetSum(int[] nums, int s){
            int[] dp = new int[s + 1];
            dp[0] = 1; //不选择正数，则全为负数，只有一种方案。
            for (int n : nums)
                for (int i = s;i >= n;i--)
                    dp[i] += dp[i - n]; //记录和为i的方案
            return dp[s];
        }
    }

    //
    class Solution_DP {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0)
                return 0;
            int sum = 0;
            for (int e : nums) sum += e;
            if (sum < S || S < -sum)
                return 0;
            int[] dp = new int[2 * sum + 1]; //覆盖从-sum到sum的所有S对应的方案数
            dp[0 + sum] = 1; //S = sum的情况，方案只有一种
            for (int i = 0; i < nums.length; i++) {
                int[] next = new int[2 * sum + 1];
                for (int j = 0; j < 2 * sum + 1; j++) {
                    if (dp[j] != 0){
                        next[j + nums[i]] += dp[j];
                        next[j - nums[i]] += dp[j];
                    }
                }
                dp = next;
            }
            return dp[S + sum];

        }
    }

}
