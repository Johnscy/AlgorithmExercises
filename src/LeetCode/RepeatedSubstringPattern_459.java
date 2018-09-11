package LeetCode;

import java.util.Scanner;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern_459 {
    //因为是子串复制多次而成，所以原始子串最多到字符串的一半位置。从此位置开始往前遍历。
    //1
    class Solution_1 {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() <= 1)
                return false;
            int len = s.length();
            for (int i = len / 2; i >= 1; i--) {
                if (s.charAt(i - 1) == s.charAt(len - 1) && len % i == 0){ //跟末尾字符比较，不一样说明肯定不是用来重复的子串，继续往前移寻找
                    int m = len / i;
                    String substring = s.substring(0,i); //不包括i
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < m; j++)
                        sb.append(substring);
                    if (sb.toString().equals(s))
                        return true;
                }
            }
            return false;
        }
    }

    //2
    class Solution_2 {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() <= 1)
                return false;
            int len = s.length();
            boolean isRepeatPattern = true;
            for (int i = len / 2; i >= 1; i--) {
                if (s.charAt(i - 1) == s.charAt(len - 1) && len % i == 0){ //跟末尾字符比较，不一样说明肯定不是用来重复的子串，继续往前移寻找
                    String substring = s.substring(0,i); //不包括i
                    for (String str : s.split(substring))
                        if (!str.isEmpty())
                            isRepeatPattern = false;
                    if (isRepeatPattern)
                        return true;
                    isRepeatPattern = true;
                }
            }
            return false;
        }
    }

    //3
    //先记录各字母出现的次数，算出最大公约数
    // （如果是由某个子串重复而成的话，重复次数就是这个最大公约数）可以简化计算
    class Solution_3 {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() <= 1)
                return false;
            int gcd = GCD(s);
            if (gcd < 2)    return false;
            for (int i = gcd; i >= 2; i--) {    //重复次数 <= gcd
                if (gcd % i == 0)
                    if (isRepeated(s,s.length()/i))
                        return true;
            }
            return false;
        }
        private boolean isRepeated(String str, int substrLen){
            int instances = str.length() / substrLen;  //重复次数
            for (int i = 0; i < instances; i++) {
                for (int j = 0; j < substrLen; j++) {
                    if (str.charAt(j) != str.charAt(j + substrLen * i))
                        return false;
                }
            }
            return true;
        }
        private int GCD(String str){
            int gcd = 0;
            int[] counts = new int[26]; //输入确定全是小写字母
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                counts[index]++;
                gcd = counts[index]; //给gcd赋值，随便就行
            }
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0)
                    gcd = GCD(gcd,counts[i]);
            }
            return gcd;
        }
        private int GCD(int a,int b){
            while (b != 0){
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }
    }

    //魔鬼啊！
    class Solution_Amazing {
        public boolean repeatedSubstringPattern(String s) {
            String str = s + s;
            return str.substring(1,str.length() - 1).contains(s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean res = new RepeatedSubstringPattern_459().new Solution_3().repeatedSubstringPattern(input);
        System.out.println(res);
    }
}
