package LeetCode;
import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */
public class MaximumLengthOfPairChain_646 {
    //DP
    class Solution_DP {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0)
                return 0;
            Arrays.sort(pairs,(o1, o2) -> (o1[0] - o2[0])); //将数组按第一个元素递增的顺序排序
            int[] dp = new int[pairs.length];

        }
    }

    //
    class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0)
                return 0;
            Arrays.sort(pairs,(o1, o2) -> (o1[0] - o2[0])); //将数组按第一个元素递增的顺序排序
            int len = 0, pre = Integer.MIN_VALUE;
            for (int[] pair : pairs){
                if (pair[0] > pre) {
                    len++;
                    pre = pair[1];
                }else if (pre < pair[1])
                    pre = pair[1];
            }
            return len;
        }
    }
}
