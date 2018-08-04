package LeetCode;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 *
 * Example 2:
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockIV_188 {
    //DP
    //通用公式：i为第i个交易日（0到prices.length - 1）；k为最多交易次数；第三项为当前持有的商品个数0或1（规定：必须在再一次购买之前卖掉商品）
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
    //此题k可变，若k >= prices.length / 2，则相当于k无限制；否则讨论0到k种情况，用数组存储：
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length <= 1 || k <= 0)
                return 0;
            if (k >= prices.length >>> 1){
                int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE, T_ik0_old;
                for (int price : prices){
                    T_ik0_old = T_ik0;
                    T_ik0 = Math.max(T_ik0, T_ik1 + price);
                    T_ik1 = Math.max(T_ik1, T_ik0_old - price);
                }
                return T_ik0;
            }else {
                int[] T_ik0 = new int[k + 1];
                int[] T_ik1 = new int[k + 1];
                Arrays.fill(T_ik1, Integer.MIN_VALUE);
                for (int price : prices)
                    for (int j = k; j > 0; j-- ){
                        T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                        T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
                    }
                return T_ik0[k];
            }
        }
    }
}
