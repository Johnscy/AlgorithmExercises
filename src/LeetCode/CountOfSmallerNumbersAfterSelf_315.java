package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author scy
 * @date 2021/06/06 02:11
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 */
public class CountOfSmallerNumbersAfterSelf_315 {

    //其实就是求逆序对的个数
    class Solution {

        public List<Integer> countSmaller(int[] nums) {
            int size = nums.length;
            List<Integer> res = new ArrayList<>(size);
            if (size == 0) {
                return res;
            }
            Set<Integer> treeSet = new TreeSet<>();
            for (int num : nums) {
                treeSet.add(num);
            }
            Map<Integer, Integer> sortedMap = new HashMap<>();
            int index = 1;
            for (int num : treeSet) {
                sortedMap.put(num, index);
                index++;
            }
            FenwickTree fenwickTree = new FenwickTree(nums);
            for (int i = size - 1; i >= 0; i--) {
                index = sortedMap.get(nums[i]);
                int reversedPairNum = fenwickTree.queryNSum(index);
                res.add(0, reversedPairNum);
                fenwickTree.updateDelta(index, 1);
            }
            return res;
        }

        //树状树组
        class FenwickTree {

            private int[] binaryIndexTree;

            private int size;


            public FenwickTree(int[] nums) {
                size = nums.length;
                binaryIndexTree = new int[size + 1];
            }


            public void updateDelta(int index, int delta) {
                refresh(index, delta);
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
                for (int i = n; i > 0; i -= lowBit(i)) {
                    res += binaryIndexTree[i];
                }
                return res;
            }
        }
    }
}
