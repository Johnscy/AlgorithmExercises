package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a string S, check if the letters can be rearranged so that
 * two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.
 * If not possible, return the empty string.
 *
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 *
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 *
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString_767 {
    class Solution {
        public String reorganizeString(String S) {
            if (S == null || S.length() <= 1)
                return "";
            int[] counts = new int[26];
            int max = Integer.MIN_VALUE;int  maxIndex = 0;
            for (int i = 0; i < S.length(); i++) {
                int  index = S.charAt(i) - 'a';
                counts[index]++;
                max = Math.max(counts[index],max);
                maxIndex = max == counts[index] ? index : maxIndex;
            }
            if (S.length() - max < max - 1)
                return "";
            else{
                //Arrays.sort(counts);    //对计数数组排下序
                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < S.length(); i++) {
//                    int index = S.charAt(i) - 'a';
//                    if (index != maxIndex && counts[index] > 0){
//                        if (counts[maxIndex] > 0){
//                            sb.append((char)(maxIndex + 'a'));
//                            counts[maxIndex]--;
//                        }
//                        sb.append((char)(index + 'a'));
//                        counts[index]--;
//                    }
//                }
//                if (counts[maxIndex] == 1)
//                    sb.append((char)(maxIndex + 'a'));
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String res =new ReorganizeString_767().new Solution().reorganizeString(input);
        System.out.println(res);
    }
}
