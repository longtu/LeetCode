package wr.leetcode.algo.best_time_to_buy_and_sell_stock_ii;

import java.util.stream.IntStream;

public class Solution {
    public int maxProfit(int[] prices) {

        return IntStream.range(0,prices.length).boxed().parallel()
                .filter( a -> a > 0)
                .map(a -> prices[a] - prices[a-1])
                .filter(a -> a > 0)
                .reduce(Integer::sum).orElse(0);
    }


    public static void main(String[] args) {
        int [] prices = {};
        System.out.println(new Solution().maxProfit(prices));
    }

}