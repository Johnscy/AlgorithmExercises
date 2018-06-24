package Target_To_Offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：假设跳n级台阶有F(n)种方法。
 * 第一步跳1级，则剩下n-1级，有F(n-1)种跳法；第一步跳2级，剩下n-2级，有F(n-2)种跳法。
 * 则F(n)=F(n-1)+F(n-2)，即斐波那契数列。
 *F(1)=1,F(2)=2
 */
public class JumpFloor {
    public class Solution {
        public int jumpFloor(int target) {
            if(target <= 2) return target;
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
