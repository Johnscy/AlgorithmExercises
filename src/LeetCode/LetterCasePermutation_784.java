package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LetterCasePermutation_784 {
    class Solution {
        public List<String> letterCasePermutation(String S) {
            if (S == null || S.length() == 0)
                return null;
            List<String> res = new ArrayList<>();
            backtrack(new StringBuilder(S),0,res);
            return res;
        }

        private void backtrack(StringBuilder sb,int i,List<String> list){
            if (i == sb.length()) {
                list.add(sb.toString());
                return;
            }
            backtrack(sb,i+1,list);
            if (Character.isLetter(sb.charAt(i))){
                char change = sb.charAt(i) ^= (1 << 5);
                sb.replace(i,i,);
            }


        }
    }
}
