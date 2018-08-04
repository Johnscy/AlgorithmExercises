package LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
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
public class BestTimeToBuyAndSellStockII_122 {
    //DP
    //通用公式：i为第i个交易日（0到prices.length - 1）；k为最多交易次数；第三项为当前持有的商品个数0或1（规定：必须在再一次购买之前卖掉商品）
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
    //此题k无限制（k <= prices.length / 2），则：
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k][0] - prices[i])
    class Solution_ConsistentWay {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1)
                return 0;
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
            int T_ik0_old;
            for (int price : prices) {
                T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0_old, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }
            return T_ik0;
        }
    }

    //
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1)
                return 0;
            int res = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i])
                    res += prices[i + 1] - prices[i];
            }
            return res;
        }
    }
}
