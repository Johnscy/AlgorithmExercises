package Target_To_Offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数将num1[0],num2[0]设置为返回结果。
 */
public class FindNumsAppearOnce {
    //用异或。一个数异或自身得到的结果为0。
    public class Solution {
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            int diff = 0;
            for (int element : array)
                diff ^= element; //得到这两个数字的异或结果
            diff &= - diff; //获得结果中倒数第一个1的位置（那位为1），这两个数在这一位上不同，就此可以分开这两个数
            for (int element : array)
                if ((element & diff) == 0) // "=="优先级比"&"高，所以要加括号
                    num1[0] ^= element;    //这个群体是这一位上为1的，包含一个出现一次的数字
                else
                    num2[0] ^= element;     //这个群体是这一位上为0的，也包含一个出现一次的数字
        }
    }
}
