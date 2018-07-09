package LeetCode;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber_198 {
    //定义dp数组用来存储最大的抢劫量，其中dp[i]表示抢到第i个住户时的最大抢劫量。
    // 由于不能抢劫邻近住户，因此如果抢劫了第i个住户那么只能抢劫i - 2或者i - 3的住户，所以
    //dp[i] = max(dp[i - 2],dp[i - 3]) + nums[i]
    class Solution1 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            int pre3 = 0, pre2 = 0, pre1 = 0;
            for (int i = 0; i < n; i++) {
                int cur = Math.max(pre2, pre3) + nums[i];
                pre3 = pre2;
                pre2 = pre1;
                pre1 = cur;
            }
            return Math.max(pre1, pre2);
        }
    }

    class Solution2 {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            int last = 0, now = 0;
            for(int i = 0;i < nums.length;i++){
                int beforelast = last;
                last = now;
                now = Math.max(now,nums[i] + beforelast);
            }
            return now;
        }
    }
}
