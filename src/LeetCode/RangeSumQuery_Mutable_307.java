package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author scy
 * @date 2021/06/05 23:15
 *
 *Given an integer array nums, handle multiple queries of the following types:
 *
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery_Mutable_307 {

     class NumArray {

        private int[] binaryIndexTree;

        private int[] nums;

        private int size;


        public NumArray(int[] nums) {
            size = nums.length;
            this.nums = nums;
            binaryIndexTree = new int[size + 1];
            for (int i = 0; i < size; i++) {
                refresh(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int diff = val - nums[index];
            nums[index] = val;
            refresh(index, diff);
        }

        public int sumRange(int left, int right) {
            return queryNSum(right) - queryNSum(left - 1);
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private void refresh(int index, int diff) {
            for (int i = index + 1; i < size + 1; i += lowBit(i)) {
                binaryIndexTree[i] += diff;
            }
        }

        private int queryNSum(int n) {
            int res = 0;
            for (int i = n + 1; i > 0; i -= lowBit(i)) {
                res += binaryIndexTree[i];
            }
            return res;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        RangeSumQuery_Mutable_307.NumArray numArray = new RangeSumQuery_Mutable_307().new NumArray(nums);
        System.out.println(Arrays.toString(numArray.binaryIndexTree));
        System.out.println(numArray.sumRange(0, 1));
        System.out.println(numArray.sumRange(1, 2));
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(Arrays.toString(numArray.binaryIndexTree));
        System.out.println(numArray.sumRange(0, 1));
        System.out.println(numArray.sumRange(1, 2));
        System.out.println(numArray.sumRange(0, 2));
    }
}
