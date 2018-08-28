package LeetCode;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance_72 {
    //DP
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1.equals("") && word2.equals(""))
                return 0;
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1]; //dp[i][j] : word1从头至i与word2从头至j，两个的编辑距离。
            for (int i = 1; i <= len1; i++)
                dp[i][0] = i;
            for (int j = 1; j <= len2; j++)
                dp[0][j] = j;
            dp[0][0] = 0;
            int insert,delete,replace,cost;
            for (int i = 1; i <= len1; i++)
                for (int j = 1; j <= len2; j++) {
                    cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                    insert = dp[i - 1][j] + 1;
                    delete = dp[i][j - 1] + 1;
                    replace = dp[i - 1][j - 1] + cost;
                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                }
            return dp[len1][len2];
        }
    }
}
