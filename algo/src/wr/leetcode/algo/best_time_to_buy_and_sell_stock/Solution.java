package wr.leetcode.algo.best_time_to_buy_and_sell_stock;

import java.util.Arrays;

public class Solution {
    public int maxProfit0(int[] prices) {

        int max = 0;
        if(null != prices) {
            int small = Integer.MAX_VALUE;
            for (int p : prices) {
                small = Math.min(p, small);
                max = Math.max(max, p - small);
            }
        }
        return max;
    }
    /**
     * Profit represents max profit with single transaction
     */
    public int maxProfit(int[] prices) {
        prices = (null == prices)?(new int[0]):(prices);
        int n = prices.length;
        int[] profit = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (i > 1) {
                profit[i] = Math.max(profit[i-1], prices[i] - min);
            }
            min = Math.min(prices[i], min);
        }
        return (n > 1) ? (profit[n-1]):(0);
    }

}
