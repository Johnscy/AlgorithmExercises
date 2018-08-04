package LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock_121 {
    //DP
    //通用公式：i为第i个交易日（0到prices.length - 1）；k为最多交易次数；第三项为当前持有的商品个数0或1（规定：必须在再一次购买之前卖掉商品）
    //T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
    //T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
    //此题k = 1，则：
    //T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
    //T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i]) = max(T[i-1][1][1], - prices[i])
    class Solution_ConsistentWay {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1)
                return 0;
            int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
            for (int price: prices) {
                T_i10 = Math.max(T_i10, T_i11 + price);
                T_i11 = Math.max(T_i11, 0 - price);
            }
            return T_i10;
        }
    }


    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;
            int buy = Integer.MAX_VALUE;
            int sell = 0;
            for(int price : prices){
                if(price < buy)
                    buy = price;
                else
                    sell = Math.max(sell,price - buy);
            }
            return sell;
        }
    }
}
