package LeetCode;

import java.util.HashMap;

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
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() <= 1)
                return false;
            HashMap<Character,Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int substringLen = 0;
            for (int i = 0; i < chars.length; i++) {
                if (!map.containsKey(chars[i]))
                    map.put(chars[i],1);
                else
                    map.put(chars[i],map.get(chars[i]) + 1);
            }
        }
    }

    //魔鬼啊！
    class Solution_Amazing {
        public boolean repeatedSubstringPattern(String s) {
            String str = s + s;
            return str.substring(1,str.length() - 1).contains(s);
        }
    }
}
