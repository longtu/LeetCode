package wr.leetcode.algo.unique_paths_ii;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || 0 == obstacleGrid.length ||
                0 == obstacleGrid[0].length) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int num [][] = new int[2][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(1 == obstacleGrid[i][j]) {
                    num[i%2][j] = 0;
                } else if(0 == i && 0 == j) {
                    num[i%2][j] = 1;
                } else if (i == 0) {
                    num[i%2][j] = num[i%2][j-1];
                } else if (j == 0) {
                    num[i%2][j] = num[(i-1)%2][j];
                } else {
                    num[i%2][j] = num[(i-1)%2][j] + num[(i)%2][j-1];
                }
            }
        }
        return num[(m-1)%2][n-1];
    }
}
