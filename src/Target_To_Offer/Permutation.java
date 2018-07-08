package Target_To_Offer;
import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
public class Permutation {
    //递归，回溯法
    public class Solution_Recursion1 {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            if (str.length() == 0 || str == null)  return res;
            FullPermutation(str.toCharArray(),0,res);
            Collections.sort(res);
            return res;
        }

        private void FullPermutation(char[] chars,int k, ArrayList<String> res){
            if (k == chars.length - 1){
                String over = String.valueOf(chars);
                //if (!res.contains(over))    //去重方法一，如果已经包含了，则不加入
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

    public class Solution_Recursion2 {
        private ArrayList<String> res = new ArrayList<>();
        public ArrayList<String> Permutation(String str) {
            if (str.length() == 0 || str == null)
                return res;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);    //先排下序
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

    //迭代：字典生成算法
    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            if (str.length() == 0 || str == null)
                return res;
            char[] chars = str.toCharArray();
            Arrays.sort(chars); //先排下序
            res.add(String.valueOf(chars)); //一个解
            int len = chars.length;
            int toFrontIndex,toBackIndex;
            while (true){
                toFrontIndex = len - 1; //toFrontIndex用来往前移动
                while (toFrontIndex > 0 && chars[toFrontIndex] < chars[toFrontIndex - 1])  //从尾开始找到第一个变小的数字的索引toFrontIndex - 1
                    toFrontIndex--;
                if (toFrontIndex == 0) break;  //如果从尾到头递增，则全部排列都已经有了，退出
                toBackIndex = toFrontIndex;toFrontIndex--;  //toFrontIndex指向第一个变小的数字
                while (toBackIndex < len && chars[toBackIndex] > chars[toFrontIndex])
                    toBackIndex++;
                toBackIndex--;
                swap(chars,toBackIndex,toFrontIndex);
                reverse(chars,toBackIndex,len - 1);
                res.add(String.valueOf(chars));
            }
            return res;
        }

        private void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }

        private  void reverse(char[] chars,int fromIndex, int endIndex) {
            if(chars == null || chars.length <= fromIndex)
                return;
            for (; fromIndex < endIndex; ++fromIndex, --endIndex)
                swap(chars,fromIndex, endIndex);
        }
    }

    //用栈来实现
    public class Solution_Stack {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            TreeSet<String> tree = new TreeSet<>();
            Stack<String[]> stack = new Stack<>();
            stack.push(new String[]{str,""});
            do{
                String[] popStrs = stack.pop();
                String oldStr = popStrs[1];
                String stackStr = popStrs[0];
                for (int i = stackStr.length() - 1;i >= 0;i--){
                    String[] strs = new String[]{stackStr.substring(0,i) + stackStr.substring(i+1),
                    oldStr + stackStr.substring(i,i+1)};
                    if (strs[0].length() == 0)
                        tree.add(strs[1]);
                    else
                        stack.push(strs);
                }
            }while (!stack.isEmpty());
            for (String s: tree)
                res.add(s);
            return res;
        }
    }

}
