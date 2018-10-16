package LeetCode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity_905 {
    //O(N)，并且相对位置不打乱。
    class Solution_Best {
        public int[] sortArrayByParity(int[] A) {
            for (int i = 0, j = 0; i < A.length; i++)
                if (A[i] % 2 == 0){
                    int temp = A[j];
                    A[j++] = A[i];
                    A[i] = temp;
                }
            return A;
        }
    }

    //计算奇数/偶数的个数，新建数组，赋值，相对位置不打乱。
    class Solution_NewArray {
        public int[] sortArrayByParity(int[] A) {
            if (A == null || A.length == 1)
                return A;
            int[] ret = new int[A.length];
            int evenCnt = 0;
            for (int a : A) {
                if (a % 2 == 0)
                    evenCnt++;
            }
            int i = 0, j = evenCnt;
            for (int a : A) {
                if (a % 2 == 0)
                    ret[i++] = a;
                else
                    ret[j++] = a;
            }
            return ret;
        }
    }

    //双指针，交换奇偶值的位置，相对位置被打乱
    class Solution_Exchange {
        public int[] sortArrayByParity(int[] A) {
            if (A == null || A.length == 1)
                return A;
            int i = 0, j = A.length - 1;
            while (i < j){
                if (A[i] % 2 == 1 && A[j] % 2 == 0){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }else if(A[i] % 2 == 0 && A[j] % 2 == 0){
                    i++;
                }else if(A[i] % 2 == 0 && A[j] % 2 == 1){
                    j--;i++;
                }else {
                    j--;
                }
            }
            return A;
        }
    }
}
