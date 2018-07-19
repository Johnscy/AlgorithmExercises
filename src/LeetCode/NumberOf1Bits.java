package LeetCode;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOf1Bits {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for(;n != 0;count++)
                n &= (n - 1);
            return count;
        }
    }
}
