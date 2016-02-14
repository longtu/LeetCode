package wr.leetcode.algo.best_time_to_buy_and_sell_stock_ii;

import java.util.stream.IntStream;

public class Solution {
    public int maxProfit0(int[] prices) {

        return IntStream.range(0,prices.length).boxed().parallel()
                .filter( a -> a > 0)
                .map(a -> prices[a] - prices[a-1])
                .filter(a -> a > 0)
                .reduce(Integer::sum).orElse(0);
    }

    /**
     * Profit represents max profit with as many transactions as possible
     */
    public int maxProfit(int[] prices) {
        prices = (null == prices)?(new int[0]):(prices);
        int n = prices.length;
        int max = 0;
        if (n > 1) {
            int [] profit = new int[n];
            for (int i = 1; i < n; ++i) {
                int diff = prices[i] - prices[i-1];
                profit[i] = Math.max(profit[i-1] + diff,  profit[i-1]);
            }
            max = profit[n-1];
        }
        return max;
    }

    public static void main(String[] args) {
        int [] prices = {};
        System.out.println(new Solution().maxProfit(prices));
    }

}