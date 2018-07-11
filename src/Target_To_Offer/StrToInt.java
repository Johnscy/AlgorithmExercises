package Target_To_Offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 输入    +2147483647
 *         1a33
 * 输出    2147483647
 *         0
 */
public class StrToInt {
    public class Solution {
        public int StrToInt(String str) {
            if (str == null || str.trim().equals(""))
                return 0;
            int res = 0;
            boolean isNegetive = str.charAt(0) == '-';
            for (int i = 0;i < str.length();i++){
                char c = str.trim().charAt(i);  //去掉开头结尾多余的空格
                if (i == 0 && (c == '+' || c == '-'))
                    continue;
                if (c > '9' || c < '0')
                    return 0;
                res = (res << 1) + (res << 3) + (c & 0xf);//res * 10 + c - '0';   //移位+ASCII值相减
            }
            return isNegetive ? -res : res;
        }
    }
}
