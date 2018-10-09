package LeetCode;
import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums == null || nums.length == 0)
                return null;
            int[] res = new int[2];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < nums.length;++i){
                if(map.containsKey(target - nums[i])){
                    res[1] = i;
                    res[0] = map.get(target - nums[i]);
                    return res;
                }
                map.put(nums[i],i);
            }
            return null;
        }
    }
}
