package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

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
    //3 - sum的解法
    class Solution {
        public int triangleNumber(int[] nums) {
            if (nums == null || nums.length < 3)
                return 0;
            int count = 0;
            Arrays.sort(nums);
            for (int i = 2; i < nums.length; i++) {
                int l = 0, r = i - 1;
                while (l < r) {
                    if (nums[l] + nums[r] > nums[i]) {
                        count += r - l;
                        r--;
                    } else
                        l++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.valueOf(str[i]);
        System.out.print(new ValidTriangleNumber_611().new Solution().triangleNumber(nums));
    }
}
