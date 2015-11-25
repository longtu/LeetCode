package wr.leetcode.algo.minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {

        if(null == grid || 0 == grid.length ||
                0 == grid[0].length) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int num [][] = new int[2][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int val = grid[i][j];

                if(0 == i && 0 == j) {
                    num[i%2][j] = val;
                } else if (i == 0) {
                    num[i%2][j] = num[i%2][j-1] + val;
                } else if (j == 0) {
                    num[i%2][j] = num[(i-1)%2][j] + val;
                } else {
                    num[i%2][j] = Math.min(num[(i-1)%2][j], num[(i)%2][j-1]) + val;
                }
            }
        }
        return num[(m-1)%2][n-1];
    }
}
