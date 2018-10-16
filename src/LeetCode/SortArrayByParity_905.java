package LeetCode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity_905 {
    //O(N)，并且相对位置不打乱
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            if (A == null)
                return null;
            for (int i = 0, j = 0; i < A.length; i++) {
                if (A[i] % 2 == 0){
                    int temp = A[i];
                    A[j++] = A[i];
                    A[i] = temp;
                }
            }
            return A;
        }
    }
}
