package LeetCode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbingStairs_70 {
    class Solution {
        //斐波那契数列。
        //假设跳上n级台阶有F(n)种方法，那在倒数第二步，有两种情况：还剩1级台阶，有F(n-1)种跳法；还剩2级台阶，有F(n-2)种跳法。
        //So:F(n) = F(n-1)+F(n-2)
        //F(1) = 1,F(2) =2
        public int climbStairs(int n) {
            if(n <= 3)
                return n;
            int fib1 = 1, fib2 = 2;
            int fib3 = 0;
            for(int i =2;i < n;i++){
                fib3 = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib3;
            }
            return fib3;
        }
    }
}
