package LeetCode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays_91 {
    class Solution {
        public int numDecodings(String s) {
            if(s == null || s.trim().equals("") || s.charAt(0) == '0')
                return 0;
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[0] = dp[1] = 1;
            int pre, cur;
            for(int i = 2;i <= len;i++){
                pre = s.charAt(i - 2) - '0';
                cur = s.charAt(i - 1) - '0';
                if((pre == 0 || pre >= 3) && cur == 0)
                    return 0;
                else if(pre == 0 || pre * 10 + cur > 26)    //这两种情况，cur当前的数字无法和前面一个结合，故等同于撇去这个数字的情况
                    dp[i] = dp[i - 1];
                else if(cur == 0)       //'0'被捆绑到前一个数字上，它俩只有一种结合，所以等同于撇去它俩的情况
                    dp[i] = dp[i - 2];
                else
                    dp[i] = dp[i - 1] + dp[i - 2];  //这种情况：当当前数字不与前面一个结合时，等同于撇去这个数字；当与前面一个数字结合时，等同于撇去俩数字
            }
            return dp[len];
        }
    }
}
