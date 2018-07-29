package LeetCode;
import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum_15 {
    //先排序，然后双指针
    class Solution_TwoPointers {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != 0))
                return res;
            Arrays.sort(nums);
            int lo, hi, twoSum;
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    lo = i + 1;hi = nums.length - 1;twoSum = -nums[i];
                    while (lo < hi) {
                        if (nums[lo] + nums[hi] == twoSum){
                            res.add(Arrays.asList(nums[lo], nums[hi], -twoSum));
                            while (lo < hi && nums[lo] == nums[lo + 1])
                                lo++;
                            while (lo < hi && nums[hi] == nums[hi - 1])
                                hi--;
                            lo++;hi--;
                        }else if (nums[lo] + nums[hi] > twoSum)
                            hi--;
                        else
                            lo++;
                    }
                }
            }
            return res;
        }
    }

    //有重复输出= =、
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != 0))
                return res;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(i,nums[i]);
            }
            int twoSum = 0;
            for(int i = 0;i < nums.length - 2;i++)
                for(int j = i + 1;j < nums.length - 1;j++){
                    twoSum = nums[i] + nums[j];
                    if (map.containsValue(-twoSum)) {
                        for (int k = j + 1; k < nums.length; k++) {
                            if (nums[k] == -twoSum && k != i && k != j)
                                res.add(Arrays.asList(nums[i], nums[j], -twoSum));
                        }
                    }
                }
            return res;
        }
    }
}
