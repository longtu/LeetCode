package wr.leetcode.algo.coin_change;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int ret = Integer.MAX_VALUE;
        if( null != coins && coins.length > 0 && amount >= 0) {
            Arrays.sort(coins);
            int k = coins.length;
            int [] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i <=amount; ++i) {
                for (int j = 0; j < k; ++j) {
                    int key = i + coins[j];
                    long val = dp[i] + 1l;
                    if(  key <= amount && val < dp[key] ) {
                        dp[key] = (int) val;
                    }
                }
            }
            ret = dp[amount];
        }
        return (Integer.MAX_VALUE == ret) ? (-1):(ret);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11));
        System.out.println(sol.coinChange(new int[]{2}, 3));
    }
}
