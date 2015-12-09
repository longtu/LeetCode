package wr.leetcode.algo.paint_house;

public class Solution {
    public int minCost(int[][] costs) {
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
}
