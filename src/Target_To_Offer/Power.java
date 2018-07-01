package Target_To_Offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路：
 *   1.全面考察指数的正负、底数是否为零等情况。
 *   2.写出指数的二进制表达，例如13表达为二进制1101。
 *   3.举例:10^1101 = 10^0001*10^0100*10^1000。
 *   4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 */
public class Power {
    public class Solution {
        public double Power(double base, int exponent) {
            double res = 1;
            boolean isNegative = false;
            if (exponent < 0){
                if(equal(base,0.0))
                    throw new RuntimeException("分母不能为0");
                isNegative = true;
                exponent = -exponent;
            }
            else if (exponent == 0)
                return 1;
            while (exponent != 0){
                if ((exponent & 1) == 1)
                    res  *= base;   //累乘
                    base *= base;   //底数的平方
                    exponent >>= 1; //指数右移一位
            }
            return isNegative? (1/res) : res;
        }
        private boolean equal(double v, double w){
            if((v - w) > -0.000001 && (v - w) < 0.000001)
                return true;
            return false;
        }
    }
}
