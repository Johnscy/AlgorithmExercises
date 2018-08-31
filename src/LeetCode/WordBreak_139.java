package LeetCode;
import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak_139 {
    //DP
    class Solution_DP1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.equals("") || s.length() == 0 || wordDict.size() == 0)
                return false;
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            int minWordLen = Integer.MAX_VALUE;
            for (String word : wordDict)
                minWordLen = word.length() < minWordLen ? word.length() : minWordLen;
            for (int i = minWordLen; i <= s.length(); i++)
                for (String str : wordDict)
                    if (str.length() <= i)
                        if (dp[i - str.length()])
                            if (s.substring(i - str.length(),i).equals(str)) {
                                dp[i] = true;
                                //i += minWordLen - 1;
                                break;
                            }
            return dp[s.length()];
        }
    }

    //
    class Solution_DP2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.equals("") || s.length() == 0 || wordDict.size() == 0)
                return false;
            Set<String> set = new HashSet<>(wordDict); //用HashSet查，O（1）的复杂度，比List好
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++)
                for (int j = 0; j < i; j++)
                    if (dp[j] && set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
            return dp[s.length()];
        }
    }
}
