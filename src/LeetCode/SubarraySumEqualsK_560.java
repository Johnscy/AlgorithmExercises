package LeetCode;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK_560 {
    //sum - k !!!!!
    class Solution_HashMap {
        public int subarraySum(int[] nums, int k) {
            if (nums == null)
                return -1;
            int sum = 0, res = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            for (int i = 0;i < nums.length;i++){
                sum += nums[i];
                if (map.containsKey(sum - k))
                    res += map.get(sum - k);
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
            return res;
        }
    }

    // = =
    class Solution_DP {
        public int subarraySum(int[] nums, int k) {
            if (nums == null)
                return -1;
            int[] sums = new int[nums.length + 1];
            int res = 0;
            sums[0] = 0;
            for (int i = 1;i < sums.length;i++)
                sums[i] = sums[i - 1] + nums[i - 1];
            for (int i = 1;i < sums.length;i++)
                for (int j = i - 1;j >= 0;j--)
                    if (sums[i] - sums[j] == k)
                        res++;
            return res;
        }
    }
}
