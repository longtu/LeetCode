package wr.leetcode.algo.best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {
    public int maxProfit(int[] prices) {

        int ret = 0;
        if(null != prices && prices.length > 1) {
            int n = prices.length;
            int [] glo = new int[n];
            int [] loc = new int[n];

            for (int i = 0; i< n; ++i) {
                if( i < 1) {
                    loc[i] = 0;
                    glo[i] = 0;
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int j = 0; j < i; ++j) {
                        int val = prices[i] - prices[j];
                        if (j-2 >= 0) {
                            val += glo[j-2];
                        }
                        if(val > max) {
                            max = val;
                        }
                    }
                    loc[i] = max;
                    glo[i] = Math.max(loc[i], glo[i-1]);
                }
            }
            ret = glo[n-1];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();


        int[][] arr = {
                {1, 2, 3, 0, 2},
                {},
                null,
                {1,2},
                {0},
                {2,1}
        };
        for (int[] a : arr) {
            System.out.println(sol.maxProfit(a));
        }

    }
}
