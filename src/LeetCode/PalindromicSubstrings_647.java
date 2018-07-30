package LeetCode;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings_647 {
    //用最长回文子串的处理方法就行！！！
    //中心扩散法
    class Solution_Diffusion {
        private int count = 0;
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0)
                return 0;
            for (int i = 0; i  < s.length(); i++) {
                extendPalindrome(s,i,i);
                extendPalindrome(s,i,i+1);
            }
            return count;
        }

        private void extendPalindrome(String s, int i, int j){
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                count++;
                i--;j++;
            }
        }
    }

    //DP
    class Solution_DP {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0)
                return 0;
            int n = s.length();
            int count = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--)
                for (int j = i; j <= n - 1; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);   //dp[i][j] : i到j的子串是否为回文
                    if (dp[i][j])
                        count++;
                }
            return count;
        }
    }

    //还有其他方法。。。就先不写了
}
