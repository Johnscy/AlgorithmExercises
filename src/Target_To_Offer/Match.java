package Target_To_Offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
/*    public class Solution {
        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null)
                return false;
            if (str.length == 0 && pattern.length == 0)
                return true;
            if (str.length != 0 && pattern.length == 0)
                return false;
            if (str.length == 0 && pattern.length != 0)
                if (pattern[1] == '*' || pattern[0] == '*')
                    return true;
                else
                    return false;
            if (str[0] != pattern[0])
                return false;
            int i = 0,j = 0;
            for (;i < pattern.length && j < str.length;i++){
                if (str[j] == pattern[i] || pattern[i] == '.'){
                    j++;
                    continue;
                }
                else if (pattern[i] == '*' && (str[j] == pattern[i - 1]))
                    j++;
                else if (pattern[i + 1] == '*')
                    continue;
                else
                    return false;
            }
            if (i == (pattern.length - 1) && j == str.length - 1)
                return true;
            return false;
        }
    }*/

    //动态规划DP
    public class Solution_DP {
        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null)
                return false;
            //if (str.equals(' ') && pattern.equals(' '))
            //    return true;
            //if (!str.equals(' ') && pattern.equals(' '))
            //    return false;
            int m = str.length, n = pattern.length;
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for (int j = 1;j <= n;j++)
                if (pattern[j - 1] == '*')
                    dp[0][j] = dp[0][j-2];
            for (int i = 1;i <= m;i++)
                for (int j = 1;j <= n;j++)
                    if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (pattern[j - 1] == '*')
                        if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.')
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        else
                            dp[i][j] = dp[i][j - 2];
                    else
                        continue;   //当str[i] != pattern[j]时，要继续看后面的情况
            return dp[m][n];
        }
    }
    //递归
    public class Solution_Recursion {
        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null)
                return false;
            int strIndex = 0, patternIndex = 0;
            return matchCore(str,strIndex,pattern,patternIndex);
        }
        private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
            if (strIndex == str.length && patternIndex == pattern.length)
                return true;
            if (strIndex != str.length && patternIndex == pattern.length)
                return false;
            //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
            if (patternIndex + 1< pattern.length && pattern[patternIndex + 1] == '*'){
                if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || (strIndex != str.length && pattern[patternIndex] == '.'))
                    return matchCore(str,strIndex,pattern,patternIndex + 2) //模式后移2，视为x*匹配0个字符
                    || matchCore(str,strIndex + 1,pattern,patternIndex + 2) //视为模式匹配1个字符
                    || matchCore(str,strIndex + 1,pattern,patternIndex); //*匹配1个，再匹配str中的下一个
                else
                    return matchCore(str,strIndex,pattern,patternIndex + 2);
            }
            //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || (strIndex != str.length && pattern[patternIndex] == '.'))
                return matchCore(str,strIndex + 1,pattern,patternIndex + 1);
            return false;
        }
    }
}
