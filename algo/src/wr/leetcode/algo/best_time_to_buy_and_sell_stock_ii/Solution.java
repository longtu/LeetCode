package wr.leetcode.algo.best_time_to_buy_and_sell_stock_ii;

import java.util.stream.IntStream;

public class Solution {

        /**
         * as many transactions as possible
         * @param prices
         * @return
         */
    public int maxProfit(int[] prices) {
        int ret = 0;
        int n = prices.length;
        if (n > 0) {
            int[] loc = new int[n];
            int[] glo = new int[n];
            for (int i = 1; i <n; ++i) {
                int diff = prices[i] - prices[i-1];
                loc[i] = Math.max( loc[i-1], (i>1)?(glo[i-2]):(0)) + diff;
                glo[i] = Math.max(glo[i-1], loc[i]);
            }
            ret = glo[n-1];
        }
        return ret;
    }

    /**
     * as many transactions as possible
     * @param prices
     * @return
     * http://coderchen.blogspot.com/2015/10/stock-max-profit-with-commision-fee.html
     * http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
     */
    public int maxProfitWithCommission(int[] prices, int commission) {
        int ret = 0;
        int n = prices.length;
        if (n > 0) {
            int[] loc = new int[n];
            int[] glo = new int[n];
            loc[0] = -commission;
            for (int i = 1; i <n; ++i) {
                int diff = prices[i] - prices[i-1];
                loc[i] = Math.max(
                        loc[i-1] + diff, // did not buy on day i-1
                        (i>1)?(glo[i-2]):(0)-commission + diff //bought on day i-1
                );
                glo[i] = Math.max(glo[i-1], loc[i]);
            }
            ret = glo[n-1];
        }
        return ret;
    }


    public static void main(String[] args) {
        int [] prices = {6,2,4};
        System.out.println(new Solution().maxProfitWithCommission(prices, 1));
        System.out.println(new Solution().maxProfit(prices));
    }

}