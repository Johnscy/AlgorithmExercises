package LeetCode;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:  "bbbab"
 * Output:  4
 * One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input:  "cbbd"
 * Output:  2
 * One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence_516 {
    //最长回文子序列。。。和子串不同！可以跳过字符。
    //求长度，可用DP
    //从右侧往左判定
    class Solution {
        public int longestPalindromeSubseq(String s) {
            if (s.equals("") || s.length() == 0)
                return 0;
            int n = s.length();
            int[][] dp = new int[n][n]; //dp[i][j] : i到j的最长回文子串的长度。
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else
                        dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
            return dp[0][n];
        }
    }

    //Top bottom recursive method with memoization
    class Solution_TopToBottom {
        public int longestPalindromeSubseq(String s) {
            if (s.equals("") || s.length() == 0)
                return 0;
            int n = s.length();
            return check(s,0,n - 1,new int[n][n]);
        }
        private int check(String s, int l, int r, int[][] memoization){
            if (memoization[l][r] != 0)
                return memoization[l][r];
            if (l > r)  return 0;
            else if (l == r) return 1;
            else if (s.charAt(l) == s.charAt(r))
                memoization[l][r] = check(s,l + 1,r - 1,memoization) + 2;
            else
                memoization[l][r] = Math.max(check(s,l + 1,r,memoization),check(s,l,r - 1,memoization));
            return memoization[l][r];
        }
    }

}
