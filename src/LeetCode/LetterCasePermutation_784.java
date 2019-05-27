package LeetCode;

import java.util.*;

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

    //DFS
    class Solution_DFS {
        public List<String> letterCasePermutation(String S) {
            List<String> res = new LinkedList<>();
            if (S == null || S.length() == 0)
                return res;
            backtrack(S.toCharArray(),0,res);
            return res;
        }

        private void backtrack(char[] chs,int i,List<String> list){
            if (i == chs.length) {
                list.add(new String(chs));
                return;
            }
            backtrack(chs,i+1,list);
            if (Character.isLetter(chs[i])){
                chs[i] ^= (1 << 5);
                backtrack(chs,i + 1,list);
            }
        }
    }

    //BFS - Queue
    class Solution_BFS {
        public List<String> letterCasePermutation(String S) {
            if (S == null || S.length() == 0)
                return new LinkedList<>();
            Queue<String> res = new LinkedList<>();
            res.offer(S);

            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i)))
                    continue;
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    char[] chs = res.remove().toCharArray();

                    chs[i] = Character.toUpperCase(chs[i]);
                    res.offer(String.valueOf(chs));

                    chs[i] = Character.toLowerCase(chs[i]);
                    res.offer(String.valueOf(chs));
                }
            }
            return new LinkedList<>(res);
        }
    }

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(new LetterCasePermutation_784().new Solution_DFS().letterCasePermutation(input));
    }
}
