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
            for (int i = 0; i <= s.length(); i++) {
                    for (String str : wordDict)
                        if (str.length() <= i )
                            if (dp[i - str.length()])
                                if (s.substring(i - str.length(), i).equals(str)) {
                                    dp[i] = true;
                                    break;
                                }
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
                    if (dp[j] && set.contains(s.substring(j,i))){   //i可以取到s.length()，所以最后一个字符能取到
                        dp[i] = true;
                        break;
                    }
            return dp[s.length()];
        }
    }

    //DP1的改进，但是失败了 = =
    class Solution_DP1_QAQ {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.equals("") || s.length() == 0 || wordDict.size() == 0)
                return false;
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            int minWordLen = Integer.MAX_VALUE;
            for (String word : wordDict)
                minWordLen = word.length() < minWordLen ? word.length() : minWordLen;
            for (int i = minWordLen, j = 0; i <= s.length(); i++) {
                if (i - j >= minWordLen)
                for (String str : wordDict)
                    if (str.length() == i - j)
                        if (dp[j])
                            if (s.substring(j, i).equals(str)) {
                                dp[i] = true;
                                    j += str.length();
                                break;
                            }
            }
            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        List<String> wordDict = new ArrayList<>();
        while (sc.hasNext()) {
            wordDict.add(sc.nextLine());
        }
        boolean ret = new WordBreak_139().new Solution_DP2().wordBreak(s, wordDict); //创建内部类对象，调用内部类方法= =、
        System.out.print(ret);
    }
}
