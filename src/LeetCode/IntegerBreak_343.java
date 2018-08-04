package LeetCode;

/**
 *Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 *  Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak_343 {
    //For convenience, say n is sufficiently large and can be broken into any smaller real positive numbers.
    // We now try to calculate which real number generates the largest product.
    //Assume we break n into (n / x) x's, then the product will be xn/x, and we want to maximize it.
    //Taking its derivative gives us n * xn/x-2 * (1 - ln(x)).
    //The derivative is positive when 0 < x < e, and equal to 0 when x = e, then becomes negative when x > e.
    //The only potential candidates are 2 and 3 since 2 < e < 3, but we will generally prefer 3 to 2.
    //All the analysis above assumes n is significantly large. When n is small (say n <= 10), it may contain flaws.
    //For instance, when n = 4, we have 2 * 2 > 3 * 1.
    //To fix it, we keep breaking n into 3's until n gets smaller than 10, then solve the problem by brute-force.
    class Solution {
        public int integerBreak(int n) {
            if (n <= 1)
                return 0;
            if (n == 2)
                return 1;
            if (n == 3)
                return 2;
            int product = 1;
            while (n > 4){
                product *= 3;
                n -= 3;
            }
            product *= n;
            return product;
        }
    }
}
