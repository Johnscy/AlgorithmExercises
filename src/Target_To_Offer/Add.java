package Target_To_Offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    //用异或：a ^ b = a + b，不包含进位
    //用 & 处理进位:(a & b) << 1为进位，递归会终止的原因是(a & b) << 1最右边会多一个0，那么继续递归，进位最右边的0会慢慢增多，最后进位会变为0，递归终止。
    public class Solution {
        public int Add(int num1,int num2) {
            if (num1 == -num2)
                return 0;
            return ((num2 == 0) ? num1 : Add(num1 ^ num2,(num1 & num2) << 1));
        }
    }
}
