package LeetCode;
import org.junit.Test;

import java.util.Scanner;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix_14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0)
                return "";
            if (strs.length == 1)
                return strs[0];
            int n = strs.length;
            int minLen = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < n;++i){
                if(strs[i].length() == 0)
                    return "";
                else if(strs[i].length() < minLen)
                    minLen = strs[i].length();
            }
            for(int i = 0;i < minLen;++i){
                char c = strs[0].charAt(i);
                int j = 1;
                for(;j < n;++j){
                    if(strs[j].charAt(i) != c)
                        break;
                }
                if(j <= n - 1)
                    return sb.toString();
                else if(j == n && strs[n - 1].charAt(i) == c)
                    sb.append(c);
                else
                    return sb.toString();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        String res = new LongestCommonPrefix_14().new Solution().longestCommonPrefix(in);
        System.out.print(res);
    }


}
