package Target_To_Offer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
public class Permutation {
    //递归
    public class Solution_recursion1 {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            if (str.length() == 0 || str == null)  return res;
            FullPermutation(str.toCharArray(),0,res);
            Collections.sort(res);
            return res;
        }

        private void FullPermutation(char[] chars,int k, ArrayList<String> res){
            if (k == chars.length - 1){
                String over=String.valueOf(chars);
                if (!res.contains(over))    //去重方法一，如果已经包含了，则不加入
                     res.add(over);
            } else{
                for (int i = k;i < chars.length;i++){
                    if (i == k || chars[k] != chars[i]) { //去重方法二，如果相同，则不交换
                        swap(chars, i, k);
                        FullPermutation(chars, k + 1, res);
                        swap(chars, i, k);
                    }
                }
            }
        }

        private void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }

    }

    public class Solution_recursion2 {
        private ArrayList<String> res = new ArrayList<>();
        public ArrayList<String> Permutation(String str) {

            if (str.length() == 0)
                return res;
            char[] chars = str.toCharArray();
            Collections.sort(chars);
            backtracking(chars, new boolean[chars.length], new StringBuilder());
            return res;
        }
        private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
            if (s.length() == chars.length) {
                res.add(s.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (hasUsed[i])
                    continue;
                if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1])  //保证不重复
                    continue;
                hasUsed[i] = true;
                s.append(chars[i]);
                backtracking(chars, hasUsed, s);
                s.deleteCharAt(s.length() - 1);
                hasUsed[i] = false;
            }
        }
    }

    //迭代
    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();

        }
    }

    //用栈来实现
    public class Solution_Stack {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();

        }
    }

}
