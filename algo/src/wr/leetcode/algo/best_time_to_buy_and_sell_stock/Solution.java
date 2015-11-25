package wr.leetcode.algo.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {

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
}
