package Target_To_Offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumFrom1ToN {
    //使用递归解法最重要的是指定返回条件，但是本题无法直接使用 if 语句来指定返回条件。
    //条件与 && 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句。
    // 利用这一特性，将递归的返回条件取非然后作为 && 的第一个条件语句，递归的主体转换为第二个条件语句，那么当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回。
    //以下实现中，递归的返回条件为 n <= 0，取非后就是 n > 0，递归的主体部分为 sum += Sum_Solution(n - 1)，转换为条件语句后就是 (sum += Sum_Solution(n - 1)) > 0。
    public class Solution_Recursion {
        public int Sum_Solution(int n) {
            if (n <= 1)
                return n;
            int res = n;
            boolean hahaha = n > 0 && ((res +=Sum_Solution(n - 1)) > 0);
            return res;
        }
    }

    //利用公式1+2+3+...+n = (1+n)*n/2
    //自己实现乘法（递归）
    public class Solution_Multiplication {
        public int Sum_Solution(int n) {
            if (n <= 1)
                return n;
            int n2 = Mutiplication(n,n);
            return (n2+n) >> 1;
        }
        private int Mutiplication(int a, int b){
            int res = 0;
            boolean hahaha = ((a & 1) == 1) && ((res += b) > 0);
            a >>= 1;
            b <<= 1;
            boolean ha = (a != 0) && ((res += Mutiplication(a,b)) > 0);
            return res;
        }
    }
}
