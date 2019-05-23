package LeetCode;

/**
 *Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 */
public class FindTheDuplicateNumber_287 {
    //nums[i] ∈[1,n]，先将数据范围-1，将i放到nums[i]中。如有重复，则存在nums[i] == nums[nums[i]]的情况。
    class Solution {
        public int findDuplicate(int[] nums) {
            if(nums == null || nums.length < 2)
                return 0;
            int res = 0;
            for(int i = 0;i < nums.length;++i)
                nums[i] -= 1;    //为了和索引对上，可以全部元素-1处理。更加清晰。
            for(int i = 0;i < nums.length;++i){
                if(nums[i] != i){
                    while(nums[i] != i){
                        if(nums[i] == nums[nums[i]]){
                            res = nums[i];
                            return res + 1;
                        }
                        swap(nums,i,nums[i]);
                    }
                }
            }
            return -1;
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}
