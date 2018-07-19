package LeetCode;

/**
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits_338 {
    class Solution_DP {
        public int[] countBits(int num) {
            if (num < 0)
                return null;
            int[] res = new int[num+1];
            res[0] = 0;
            if (num == 0)
                return res;
            for (int i = 1;i <= num;i++)
                res[i] = res[i >> 1] + (i & 1);
            return res;
        }
    }

    class Solution {
        public int[] countBits(int num) {
            if(num < 0)
                return null;
            int[] count = new int[num + 1];
            count[0] = 0;
            if(num == 0)
                return count;
            int tmp;
            for(int i = 1;i <= num;i++){
                tmp = 0;
                for (;i != 0;tmp++)
                    i &= (i - 1);
                count[i] = tmp;
            }
            return count;
        }
    }
}
