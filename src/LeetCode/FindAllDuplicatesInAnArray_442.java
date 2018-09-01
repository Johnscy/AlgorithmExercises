package LeetCode;
import java.util.*;

/**
 *Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray_442 {
    // nums[i]∈[1,nums.length]
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return res;
            for (int i = 1; i <= nums.length; i++) {
                while (nums[i - 1] != i){
                    if (nums[i - 1] == -1)  break;
                    if (nums[i - 1] == nums[nums[i - 1] - 1])
                        if(nums[i - 1] != -1) {
                            res.add(nums[i - 1]);
                            nums[i - 1] = -1;
                            break;
                        }
                    swap(nums,i - 1,nums[i - 1] - 1);
                }
            }
            return res;
        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.valueOf(str[i]);
        System.out.print(new FindAllDuplicatesInAnArray_442().new Solution().findDuplicates(nums));
    }
}
