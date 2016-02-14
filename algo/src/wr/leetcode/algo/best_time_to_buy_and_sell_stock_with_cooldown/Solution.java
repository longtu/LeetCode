package wr.leetcode.algo.best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {
    public int maxProfit0(int[] prices) {

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

    public int maxProfit(int[] prices) {
        prices = (null == prices)?(new int[0]):(prices);
        int n = prices.length;
        int ret = 0;

        if ( n > 1) {
            int[] loc = new int[n];
            int[] glo = new int[n];
            for (int i = 1; i < n; ++i) {
                int diff = prices[i] - prices[i-1];
                //last buy happen on i-1 day
                if (i-3 >= 0) {
                    loc[i] = glo[i-3] + diff;
                } else {
                    loc[i] = diff;
                }
                int notBuyYesterday = loc[i-1] + diff; // last buy did NOT happen on i-1 day
                loc[i] = Math.max(loc[i], notBuyYesterday);

                glo[i] = Math.max(glo[i-1], loc[i]);
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
                {2,1},
                {2,1,4}
        };
        for (int[] a : arr) {
            System.out.println(sol.maxProfit(a));
            System.out.println(sol.maxProfit0(a));
            System.out.println();
        }

    }
}
