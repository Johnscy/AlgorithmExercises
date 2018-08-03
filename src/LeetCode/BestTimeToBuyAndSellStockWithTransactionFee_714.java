package LeetCode;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
 * and a non-negative integer fee representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 *
 * Return the maximum profit you can make.
 *
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    //DP
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0 || fee < 0)
                return 0;
            int T_ik0 = 0,  T_ik1 = Integer.MIN_VALUE;  //T_ik0 : T[i][k][0]，第i天，整个过程允许最多交易k次（此处为prices.length / 2），手上拥有0件商品
            for (int price : prices){
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0_old,T_ik1 + price);
                T_ik1 = Math.max(T_ik1,T_ik0_old - price - fee);
            }
            return T_ik0;
        }
    }
}
