package LeetCode;

/**
 *Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 *
 * Example:
 * Given n = 2, return 91.
 * (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits_357 {
    //数学方法：
    //F[n]:长度为n的数字中unique digits的个数
    //F[1] = 10(0,1,2,...,9)
    //F[2] = 9 * 9
    //F[3] = 9 * 9 * 8
    //....
    //F[10] = 9 * 9 * 8 * 7 *...* 1
    //F[11] = F[12] = .... = 0
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n <= 0)
                return 1;
            int res = 10, uniqueDigits = 9, availableNum = 9;
            while (n -- > 1 && availableNum > 0){
                uniqueDigits *= availableNum;
                res += uniqueDigits;
                availableNum--;
            }
        return res;
        }
    }

    //DP,backtracking
    class Solution_Backtracking {
        public int countNumbersWithUniqueDigits(int n) {
            if (n <= 0)
                return 1;
            if (n > 10) //超过10位，必有重复数字
                n = 10;
            return doCount(n,new boolean[10],0);
        }
        private int doCount(int n, boolean[] used, int d){
            if (d == n) //d为位数
                return 1;
            int total = 1;
            for (int i = (d == 0) ? 1 : 0; i < 10; i++) {
                if (!used[i]){
                    used[i] = true;
                    total += doCount(n,used,d + 1);
                    used[i] = false;
                }
            }
            return total;
        }
    }
}
