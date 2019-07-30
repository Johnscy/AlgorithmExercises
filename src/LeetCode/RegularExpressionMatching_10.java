package LeetCode;

/**
 * @author scy
 * @date 2019/07/29 00:47
 */

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * <p>
 * Example 1:
 * Input: s = "aa" p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * Input: s = "aa" p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Example 3:
 * Input: s = "ab" p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * Example 4:
 * Input: s = "aab" p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * <p>
 * Example 5:
 * Input: s = "mississippi" p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching_10 {
    //DP
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p == null || p.length() == 0) {
                return (s == null || s.length() == 0);
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; //dp[i][j]表示字符串s从头至i和正则表达式串p从头至j匹配与否
            dp[0][0] = true;   //s与p皆为“”时，是匹配的
            for (int j = 2; j <= p.length(); j++) {
                dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2]; //"a*b*c*" 匹配 ""
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2]; //这个'*'作为前面字母的0次重复
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
