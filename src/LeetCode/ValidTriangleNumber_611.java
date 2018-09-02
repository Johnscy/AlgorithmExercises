package LeetCode;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers,
 * your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 */
public class ValidTriangleNumber_611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            if (nums == null || nums.length < 3)
                return 0;
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length - 3; i++) {
                int count = 0;
                for (int j = i + 1; j <= nums.length - 2; j++) {
                    if (nums[i] + nums[j])
                }
            }
        }
    }
}
