package LeetCode;
import java.util.Scanner;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 */
public class MaximumSwap_670 {
    //遍历交换O(n^2) = =
    class Solution_1 {
        private String res;
        public int maximumSwap(int num) {
            if (num == 0)   return 0;
            String s = String.valueOf(num);
            res = s;
            for (int i = 0; i < s.length(); i++)
                for (int j = i + 1; j < s.length(); j++)
                    swapAndCompare(s,i,j);
            return Integer.valueOf(res);
        }
        private void swapAndCompare(String s, int i, int j){
            if (i > j || s.equals(""))    return;
            StringBuilder newSB = new StringBuilder(s);
            char c = newSB.charAt(i);
            newSB.setCharAt(i,newSB.charAt(j));
            newSB.setCharAt(j,c);
            if (newSB.toString().compareTo(res) > 0)
                res = newSB.toString();
        }
    }

    //
    class Solution_Best {
        public int maximumSwap(int num) {
            if (num == 0)   return 0;
            char[] digits = Integer.toString(num).toCharArray();// ("" + num).toCharArray()
            int[] buckets = new int[10];        //0 - 9每个数字对应桶中一个位置
            for (int i = 0; i < digits.length; i++)
                buckets[digits[i] - '0'] = i;   //记录num中每位数字
            for (int i = 0; i < digits.length; i++)
                for (int j = 9; j > digits[i] - '0'; j--)
                    if (buckets[j] > i){
                        char temp = digits[i];
                        digits[i] = digits[buckets[j]];
                        digits[buckets[j]] = temp;
                        return Integer.valueOf(new String(digits));
                    }
            return num;
        }
    }
    //
    class Solution_2 {
        public int maximumSwap(int num) {
            if (num == 0) return 0;
            char[] digits = ("" + num).toCharArray();
            int firstGreater = 0;   //找到第一个比之前一位大的数，把数分成两部分，前面（降序） + 后面
            while (++firstGreater < digits.length && digits[firstGreater - 1] >= digits[firstGreater]);
            if (firstGreater == digits.length)  return num; //从头至尾都是降序，那么此组合就是最大的数
            int maxPosition = firstGreater; //找到后面部分最大的数的下标
            char max = digits[firstGreater];
            for (int i = firstGreater; i < digits.length; i++)
                if (digits[i] > max){
                    max = digits[i];
                    maxPosition = i;
                }
            for (int i = 0; i < firstGreater; i++) {
                if (digits[maxPosition] > digits[i]){
                    char temp = digits[i];
                    digits[i] = digits[maxPosition];
                    digits[maxPosition] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
            return num;
        }
    }

    //test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = new MaximumSwap_670().new Solution_Best().maximumSwap(num);
        System.out.print(res);
    }
}
