package LeetCode;

/**
 * Initially on a notepad only one character 'A' is present.
 * You can perform two operations on this notepad for each step:
 *
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 *
 * Example 1:
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 */
public class TwoKeysKeyboard_650 {
    //DP
    class Solution_DP {
        public int minSteps(int n) {
            if(n <= 1)
                return 0;
            int[] dp = new int[n + 1];
            dp[1] = 0;
            for(int i = 2;i <= n;i++) {
                dp[i] = i;   //素数就是i次操作：C + (i - 1)P
                for (int j = i - 1; j > 0; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + i / j;    //合数就是最大因数j对应的次数 + C + (i / j - 1)P
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

    //
    class Solution {
        public int minSteps(int n) {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    res += i;
                    n = n / i;
                }
            }
            return res;
        }
    }
}
