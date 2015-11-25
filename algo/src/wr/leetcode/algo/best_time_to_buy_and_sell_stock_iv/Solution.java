package wr.leetcode.algo.best_time_to_buy_and_sell_stock_iv;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangran on 3/16/15.
 */
public class Solution {



    public int maxProfit(int k, int[] prices) {
        int ret = 0;
        if(null != prices && k >0 && prices.length > 0) {
            int n = prices.length;
            if( k >= n - 1) {
                ret = maxProfit(prices);
            } else {
                int[][] loc = new int[k+1][n];
                int[][] glo = new int[k+1][n];

                for (int i = 1; i <=k; ++i) {
                    for (int j = 1; j < n; ++j) {
                        int diff = prices[j] - prices[j-1];
                        loc[i][j] = Math.max (loc[i][j-1] + diff,
                            glo[i-1][j-1] + diff);
                        glo[i][j] = Math.max (Math.max (loc[i][j], glo[i][j-1]),
                            glo[i-1][j]);
                    }
                }
                ret = glo[k][n-1];
            }
        }
        return ret;
    }

    public int maxProfit(int [] prices ) {
        int sum = 0;
        for (int i = 0; i < prices.length; ++i) {
            if(i > 0 && prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }








/*
    public int maxProfit(int k, int[] prices) {
        if ( prices == null || prices.length <2 || k <=0 ) {
            return 0;
        }
        int n = prices.length;
        if(k > n-1) {
            return maxProfit(prices);
        }
        int [][]global = new int [2][n];
        int [][]local = new int [2][n];

        for (int j = 1; j <n; ++j)
            for(int i = 1; i <=k; ++i) {
                int diff = prices[j]-prices[j-1];
                local[i%2][j] = Math.max(local[i%2][j-1] + diff,
                        global[(i-1)%2][j-1] + Math.max(diff,0));
                global[i%2][j] = Math.max(global[i%2][j-1], local[i%2][j]);
            }
        for(int [] arr : global)
            System.out.println(Arrays.toString(arr));
        return global[k%2][n-1];
    }

    private int maxProfit(int [] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
    */
}
