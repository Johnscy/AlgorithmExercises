package Target_To_Offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public class Solution {
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
    }
}
