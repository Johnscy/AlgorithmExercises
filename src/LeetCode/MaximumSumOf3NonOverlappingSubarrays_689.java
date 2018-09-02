package LeetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * In a given array nums of positive integers,
 * find three non-overlapping subarrays with maximum sum.
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * Return the result as a list of indices representing the starting position of each interval (0-indexed).
 * If there are multiple answers, return the lexicographically smallest one.
 *
 * Example:
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 */
public class MaximumSumOf3NonOverlappingSubarrays_689 {
    // DP
    // If the middle interval is [i, i+k-1], where k <= i <= n-2k,
    // the left interval has to be in subrange [0, i-1],
    // and the right interval is from subrange [i+k, n-1].
    // posLeft[i] is the starting index for the left interval in range [0, i];
    // posRight[i] is the starting index for the right interval in range [i, n-1];
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] res = new int[3];
            int n = nums.length;
            if (nums == null || n <= 2 || n / k < 3)
                return res;
            int[] sums = new int[n + 1], posLeft = new int[n], posRight = new int[n];
            for (int i = 1; i <= n; i++)
                sums[i] = nums[i - 1] + sums[i - 1];
            //计算左边的
            for (int i = k ,last = -1; i <= n - 2*k; ++i) {
                int sum = sums[i] - sums[i - k];     // k个数的和
                if (sum > last){
                    posLeft[i] = i - k;
                    last = sum;
                } else
                    posLeft[i] = posLeft[i - 1];
            }
            //计算右边的
            for (int i = n - 2*k,last = -1; i >= k; --i) {
                int sum = sums[i + 2*k] - sums[i + k]; // k个数的和
                if (sum >= last){
                    posRight[i] = i + k;
                    last = sum;
                } else
                    posRight[i] = posRight[i + 1];
            }
            //计算中间的
            for (int i = k, maxSum = -1; i <= n - 2*k; ++i) {
                int l = posLeft[i], r = posRight[i];
                int sum = (sums[l + k] - sums[l])+(sums[r + k] - sums[r])+(sums[i + k] - sums[i]);
                if (sum > maxSum){
                    maxSum = sum;
                    res[0] = l;res[1] = i;res[2] = r;
                }
            }
            return res;
        }
    }

    //test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++)
             nums[i] = Integer.valueOf(s[i]);
        int k = Integer.valueOf(sc.nextLine());
        int[] res = new MaximumSumOf3NonOverlappingSubarrays_689().new Solution().maxSumOfThreeSubarrays(nums,k);
        List<Integer> output = new ArrayList<>();
        for (int e : res)
            output.add(e);
        System.out.print(output);
    }
}
