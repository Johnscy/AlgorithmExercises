package LeetCode;
import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 */
public class Subsets_78 {    //这一题输入数组不包含重复元素！！！！！
    //回溯法，递归
    class Solution_BackTracking {
        private List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            if(nums == null || nums.length == 0)
                return res;
            List<Integer> subset = new ArrayList<>();
            backtracking(nums,subset,0);
            return res;
        }
        private void backtracking(int[] nums, List<Integer> subset,int k){
            res.add(new ArrayList<Integer>(subset));
            for(int i = k;i < nums.length;i++){
                subset.add(nums[i]);
                backtracking(nums,subset,i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    //组合，非递归
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0)
                return res;
            res.add(new ArrayList<Integer>());
            int size;
            for (int num : nums){
                size = res.size();
                for (int i = 0;i < size;i++) {
                    List<Integer> subset = new ArrayList<>(res.get(i));
                    subset.add(num);
                    res.add(subset);
                }
            }
            return res;
        }
    }

    //位运算。移位。不包含重复数字的数组有2^n个子集。
    // 数组中的n个数可以用n个二进制位表示，当某一位为1表示选择对应的数，为0表示不选择对应的数。
    class Solution_BitwiseOperation {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return res;
            int n = nums.length;
            for (int i = 0;i < (1 << n);i++){
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & i) != 0)    //判断i中哪些位为1，为1的加入subset
                        subset.add(nums[j]);
                }
                res.add(subset);
            }
            return res;
        }
    }
}
