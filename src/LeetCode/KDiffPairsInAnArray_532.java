package LeetCode;

import sun.awt.image.IntegerInterleavedRaster;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 */
public class KDiffPairsInAnArray_532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            if (nums == null || nums.length < 2)
                return 0;
            int res = 0;
            if (k == 0){
                Arrays.sort(nums);
                for (int i = 1;i < nums.length;) {
                    if (nums[i - 1] == nums[i]) {
                        while (nums[i - 1] == nums[i]) {
                            if (i == nums.length - 1)
                                break;
                            ++i;
                        }
                        res++;
                        if (i == nums.length - 1)
                            break;
                    }else {
                        ++i;
                    }
                }
            }else {
                HashSet<Integer> set = new HashSet<>();
                for (int num : nums)
                    set.add(num);
                for (int e : set) {
                    if (set.contains(e + k))
                        res++;
                }
            }
            return res;
        }
    }
}
