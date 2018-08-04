package LeetCode;

/**
 *Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII_123 {
    //DP
    //通用公式：i为第i个交易日（0到prices.length - 1）；k为最多交易次数；第三项为当前持有的商品个数0或1（规定：必须在再一次购买之前卖掉商品）
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
    //此题k = 2，则可以交易2次或1次：
    //T[i][2][0] = max(T[i - 1][2][0], T[i - 1][2][1] + prices[i])
    //T[i][2][1] = max(T[i - 1][2][1], T[i - 1][1][0] - prices[i])
    //T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
    //T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i])
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1)
                return 0;
            int T_i20 = 0, T_i21 = Integer.MIN_VALUE;
            int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
            for (int price: prices) {
                T_i20 = Math.max(T_i20, T_i21 + price);
                T_i21 = Math.max(T_i21, T_i10 - price);
                T_i10 = Math.max(T_i10, T_i11 + price);
                T_i11 = Math.max(T_i11, - price);
            }
            return T_i20;
        }
    }
}
