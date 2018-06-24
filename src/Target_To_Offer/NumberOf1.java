package Target_To_Offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：
 * x = x & (x-1) 表达式的意思就是:把x的二进制表示从低位开始，将遇到的第一个为1的比特位置0。
 * 然后计数，每计一次，表示有一个1，直到结果为0。
 */
public class NumberOf1 {
    public class Solution {
        public int NumberOf1(int n) {
            int count = 0;
            for (;n != 0;count++)
                n = n & (n-1);
            return count;
        }
    }
}
