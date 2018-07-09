package LeetCode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            int res = Integer.MIN_VALUE; //最后的结果
            int sum = 0;//中途的累加和
            for(int element : nums){
                sum = Math.max(sum + element,element);
                res = Math.max(sum,res);
            }
            return res;
        }
    }
}
