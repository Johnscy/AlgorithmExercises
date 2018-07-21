package LeetCode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring_5 {
    //DP          O(n^2)
    class Solution_DP1 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1)
                return s;
            int[][] dp = new int[len][len]; //dp[i][j]表示以s[i]开始s[j]结尾的回文串的长度。如果这个字符串不是回文串，让dp[i][j]=0。显然，j>=i，只需往dp填j>=i的部分即可。
            int start = 0, maxLen = 1;      //最长回文子串的开始索引和长度
            for (int j = 0;j < len;j++)
                for (int i = j;i >= 0;i--){
                    if (s.charAt(i) == s.charAt(j)){
                        if (i == j)
                            dp[i][j] = 1;
                        else if (j - i == 1)
                            dp[i][j] = 2;
                        else if (dp[i + 1][j - 1] > 0)
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        else
                            dp[i][j] = 0;
                    }
                    else
                        dp[i][j] = 0;
                    if (dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        start = i;
                    }
                }
            return s.substring(start,start + maxLen);
        }
    }

    class Solution_DP2 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1)
                return s;
            boolean[][] dp = new boolean[len][len]; //dp[i][j]表示以s[i]开始s[j]结尾的子串是否为回文。显然，j>=i，只需往dp填j>=i的部分即可。
            int start = 0, maxLen = 1;      //最长回文子串的开始索引和长度
            for (int i = 0;i < len;i++){
                dp[i][i] = true;
                if ((i + 1 < len) && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    maxLen = 2;
                    start = i;
                }
            }
            int j;
            for (int L = 3;L <= len;L++)    //子串的长度
                for (int i = 0;i < len - L + 1;i++){
                    j = i + L - 1;
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        maxLen = L;
                        start = i;
                    }
                }
            return s.substring(start,start + maxLen);
        }
    }

    //Manacher解法 O(n)
    class Solution_Manacher {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1)
                return s;
            // 1.构造新的字符串
            // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
            StringBuilder str = new StringBuilder();
            str.append('$');
            str.append('#');
            for (char c : s.toCharArray()){
                str.append(c);
                str.append('#');
            }
            int newLen = str.length();  //最前面多个'$'
            int[] p = new int[newLen];
            int start = 0, maxLen = 0;
            int id = 0, mx = 0;         //当前右边界最大的回文子串的中点和右边界!!!!
            for (int i = 1;i < newLen;i++){
                if (i >= mx)
                    p[i] = 1;
                else
                    p[i] = mx - i > p[2 * id - i] ? p[2 * id - i] : mx - i;
                while (i - p[i] >= 0 && i + p[i] < newLen && str.charAt(i - p[i]) == str.charAt(i + p[i]))
                    p[i]++;
                if (mx < i + p[i]){
                    id = i;
                    mx = i + p[i];
                }
                if (p[i] - 1 > maxLen){
                    maxLen = p[i] - 1;
                    start = (i - p[i]) / 2;
                }
            }
            return s.substring(start,start + maxLen);
        }
    }

    //中心扩散法  O(n^2)
    class Solution_Diffusion {
        private int maxLen, lo;     //最长回文子串的长度和起始索引
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1)
                return s;
            for (int i = 0;i+1 < len;i++){
                extendPalindrome(s,i,i);        //奇数长度
                extendPalindrome(s,i,i + 1); //偶数长度
            }
            return s.substring(lo,lo + maxLen);
        }
        private void extendPalindrome(String s, int i, int j){
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if (maxLen < j - i + 1){
                lo = i + 1; //跳出上面的循环时，i多减了一次。。。加回来
                maxLen = j - i + 1;
            }
        }
    }

    //another O(n^2)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1)
                return s;
            char[] ca = s.toCharArray();
            int rs = 0, re = 0;
            int max = 0;
            for (int i = 0; i < len; i++) {
                if (isPalindrome(ca, i - max - 1, i)) {
                    rs = i - max - 1;
                    re = i;
                    max += 2;
                } else if (isPalindrome(ca, i - max, i)) {
                    rs = i - max;
                    re = i;
                    max += 1;
                }
            }
            return s.substring(rs, re + 1); //substring不包含endIndex，所以要+1
        }
        private boolean isPalindrome(char[] ca, int s, int e) {
            if (s < 0) return false;
            while (s < e) {
                if (ca[s++] != ca[e--]) return false;
            }
            return true;
        }
    }
}
