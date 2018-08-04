package LeetCode;

/**
 *Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    //DP
    //通用公式：i为第i个交易日（0到prices.length - 1）；k为最多交易次数；第三项为当前持有的商品个数0或1（规定：必须在再一次购买之前卖掉商品）
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
    //此题交易完，即卖出商品后要休息一天，不能在休息天买入，则：
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 2][k - 1][0] - prices[i])
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1)
                return 0;
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE, T_ik0_old, T_ik0_pre = 0;
            for (int price : prices){
                T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
                T_ik0_pre = T_ik0_old;
            }
            return T_ik0;
        }
    }
}
