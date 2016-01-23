package wr.leetcode.algo.paint_house;

public class Solution {
    public int minCost0(int[][] costs) {
        int ret = 0;
        if( null != costs && 0 != costs.length ) {
            int n = costs.length;
            int [] red = new int[2];
            int [] blue = new int[2];
            int [] green = new int[2];

            for (int i = 1; i <= n; ++i ) {
                red[i%2] = Math.min(blue[(i-1)%2], green[(i-1)%2]) + costs[i-1][0];
                blue[i%2] = Math.min(red[(i-1)%2], green[(i-1)%2]) + costs[i-1][1];
                green[i%2] = Math.min(blue[(i-1)%2],red[(i-1)%2]) + costs[i-1][2];
            }
            ret = Math.min(Math.min(red[n%2], blue[n%2]), green[n%2]);
        }
        return ret;
    }

    public int minCost(int[][] costs) {

        int ret = 0;
        int n = costs.length;

        if ( n > 0 ) {
            int[][] dp = new int[n][3];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 3; ++j) {
                    dp[i][j] = costs[i][j];
                    if( i > 0 ) {
                        dp[i][j] += Math.min(dp[i-1][(j+1)%3], dp[i-1][(j-1)%3]);
                    }
                }
            }
            ret = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        }
        return ret;
    }
}
