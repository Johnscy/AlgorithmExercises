package Target_To_Offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {
    public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int count = 0;
            for (int i = 1;i <= n;i *= 10){  //i = 1,10,100,1000.....
                int a = n /i, b = n % i;  //a为高位，b为低位
                count += (a + 8)/10 * i + (a % 10 == 1 ? b + 1 : 0);
            }
            return count;
        }
    }
}
