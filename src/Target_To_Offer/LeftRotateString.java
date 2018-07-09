package Target_To_Offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S="abcXYZdef",要求输出循环左移3位后的结果，即"XYZdefabc"。
 */
public class LeftRotateString {
    //第一个想法就是队列XD
    public class Solution_Queue {
        public String LeftRotateString(String str,int n) {
            if (str == null || n < 0 || str.length() == 0)
                return "";
            Queue<Character> queue = new LinkedList<>();
            for (char c : str.toCharArray())
                queue.offer(c);
            int k = n % queue.size();
            while (k-- > 0){
                char c = queue.poll();
                queue.offer(c);
            }
            StringBuilder sb = new StringBuilder(queue.size());
            for (char c : queue)
                sb.append(c);
            return sb.toString();
        }
    }
    // YX = (XTYT)T
    public class Solution_ {
        public String LeftRotateString(String str,int n) {
            if (str == null || n < 0 || str.length() == 0)
                return "";
            char[] chars = str.toCharArray();
            reverse(chars,0,n-1);
            reverse(chars,n,str.length()-1);
            reverse(chars,0,str.length()-1);
            return new String(chars);
        }
        private void reverse(char[] chars,int i, int j){
            while (i < j){
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;j--;
            }
        }
    }

    //emmm.....
    public class Solution_Cut {
        public String LeftRotateString(String str,int n) {
            if (str == null || n < 0 || str.length() == 0)
                return "";
            int len = str.length();
            n = n % len;
            //str += str;
            //return str.substring(n,n + len);//n到n+len-1
            StringBuilder sb=new StringBuilder(str);
            sb.append(sb.substring(0,n));
            return sb.substring(n,sb.length());
        }
    }
}
