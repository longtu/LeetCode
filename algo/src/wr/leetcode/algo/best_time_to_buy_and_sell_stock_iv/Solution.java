package wr.leetcode.algo.best_time_to_buy_and_sell_stock_iv;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangran on 3/16/15.
 */
public class Solution {

    public LinkedList<Integer> buildProfitInterval( int[] prices){

        LinkedList<Integer> profits = new LinkedList<Integer>();
        for (int i = 1; i < prices.length; ++i){
            int profit = prices[i] - prices[i-1];
            Integer prevProfit = profits.peekLast();
            if(prevProfit == null || prevProfit*profit < 0) {
                profits.addLast(profit);
            } else {
                profits.removeLast();
                profits.offerLast(prevProfit+profit);
            }
        }

        return profits;
    }

    public int sumPositives( List<Integer> profits){
        int sum = 0;
        for (Integer profit: profits){
            if(profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    public int getPositives(List<Integer> profits){
        int postivies = 0;
        for (Integer profit: profits){
            if(profit > 0) {
                postivies++;
            }
        }
        return postivies;
    }

    public int getTopKPositives(int k, LinkedList<Integer> profits) {
        Collections.sort(profits);
        int sum = 0;
        for(int i = 0; i<k; ++i) {
            sum += profits.pollLast();
        }
        return sum;
    }

    public int maxProfit(int k, LinkedList<Integer> profits){

        if(k >= getPositives(profits) ) {
            return sumPositives(profits);
        }

        int maxMerge = 0;
        int maxMergeIndex = -1;
        for( int i = 1; i < profits.size()-1; ++i) {
            if(profits.get(i) < 0 && profits.get(i-1) > 0 && profits.get(i+1) > 0) {
                int tmp = profits.get(i) + profits.get(i-1) + profits.get(i+1);
                if(tmp > maxMerge) {
                    maxMerge = tmp;
                    maxMergeIndex = i;
                }
            }
        }
        if(maxMergeIndex != -1) {
            profits.remove(maxMergeIndex+1);
            profits.remove(maxMergeIndex);
            profits.remove(maxMergeIndex-1);
            profits.add(maxMergeIndex-1,maxMerge);
            return maxProfit(k, profits);

        } else {
            return getTopKPositives(k, profits);
        }

    }

    public int maxProfit(int k, int[] prices) {
        if ( prices == null || prices.length <2 || k <=0 ) {
            return 0;
        }
        return maxProfit( k, buildProfitInterval(prices));
    }

    public int maxProfit(int[] prices) {
        return max(prices, 2);
    }

    public int max(int[] prices, int k) {       // k: k times transactions
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions,
        // where there is transaction happening on i day
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}
