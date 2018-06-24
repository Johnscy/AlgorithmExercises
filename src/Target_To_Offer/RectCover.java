package Target_To_Offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路：假设2*n的矩形有f(n)种覆盖方法。
 * 第一块横着放，剩下2*(n-1)的面积，有f(n-1)种方法；第一块竖着放，剩下2*(n-2)的面积，有f(n-2)的方法
 *so....f(n) = f(n-1) + f(n-2)
 * f(1) = 1, f(2) = 2
 */
public class RectCover {
    public class Solution {
        public int RectCover(int target) {
            if (target <= 2)    return target;
            int fn = 0;
            int fib1 = 1, fib2 = 2;
            for (int i = 3;i <= target;i++){
                fn = fib1 + fib2;
                fib1 = fib2;
                fib2 = fn;
            }
            return fn;
        }
    }
}
