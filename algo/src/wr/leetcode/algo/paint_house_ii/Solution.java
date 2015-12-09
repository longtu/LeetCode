package wr.leetcode.algo.paint_house_ii;

public class Solution {
    public int minCostII(int[][] costs) {
        int ret = 0;
        if( null != costs && 0 < costs.length && costs[0].length > 0) {
            int n = costs.length;
            int k = costs[0].length;
            int [][] minCosts = new int[k][2];

            for (int i = 1; i <= n; ++i ) {
                int minColor = minColor(i-1, -1, minCosts);
                int subColor = minColor(i-1, minColor, minCosts);
                for (int color = 0; color < k; ++color) {
                    int prev;
                    if(color == minColor) {
                        prev = minCosts[subColor][(i-1)%2];
                    } else {
                        prev = minCosts[minColor][(i-1)%2];
                    }
                    minCosts[color][i%2] = prev + costs[i-1][color];
                }

            }
            int lastColor = minColor(n, -1, minCosts);
            ret = minCosts[lastColor][n%2];
        }
        return ret;
    }


    int minColor( int day, int skipColor, int[][] minCosts ) {
        int k = minCosts.length;
        int minColor = 0;

        if( k > 1 ) {
            int minValue = Integer.MAX_VALUE;
            minColor = -1;
            for (int color = 0; color < minCosts.length; ++color) {
                if(skipColor != color && minCosts[color][day%2] < minValue ) {
                    minValue = minCosts[color][day%2];
                    minColor = color;
                }
            }
        }
        return minColor;
    }

    public static void main(String[] args) {
        int[][] arr = {{8}};
        Solution sol = new Solution();
        System.out.println(sol.minCostII(arr));
    }

    //BUG: Wrong fix
    /*
    int minColor( int day, int skipColor, int[][] minCosts ) {
        int minValue = minCosts[0][day%2];
        int minColor = 0;
        for (int color = 1; color < minCosts.length; ++color) {
            if(skipColor != color && minCosts[color][day%2] < minValue ) {
                minValue = minCosts[color][day%2];
                minColor = color;
            }
        }
        return minColor;
    }*/

    //BUG: cannot deal with single color, single day
    /*
    int minColor( int day, int skipColor, int[][] minCosts ) {
        int minValue = Integer.MAX_VALUE;
        int minColor = -1;
        for (int color = 0; color < minCosts.length; ++color) {
            if(skipColor != color && minCosts[color][day%2] < minValue ) {
                minValue = minCosts[color][day%2];
                minColor = color;
            }
        }
        return minColor;
    }*/
}
