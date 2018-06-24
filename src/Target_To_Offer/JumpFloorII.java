package Target_To_Offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：假设跳上n级共有f(n)种跳法。
 * 第一步跳1级，剩下n-1级，有f(n-1)种方法；第一步跳2级，有f(n-2)种方法........第一步跳n-1级，有f(1)种跳法；第一步跳n级，有1种跳法。
 * f(n) = f(n-1) + f(n-2) + f(n-3) +...+f(2) + f(1) + 1
 * f（n-1） = f(n-2) + f(n-3) +...+f(2) + f(1) + 1
 * 得：f(n) = 2 * f(n-1)
 * f(1) = 1. f(2) = 2
 */
public class JumpFloorII {
    public class Solution {
        public int JumpFloorII(int target) {
            if (target <= 1)    return target;
            return  1<<(--target);
        }
    }
}
