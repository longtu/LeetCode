package wr.leetcode.algo.unique_paths;

public class Solution {
    public int uniquePaths(int m, int n) {

        if(m < 1 || n < 1) {
            return 0;
        }

        int num [][] = new int[2][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(0 == i && 0 == j) {
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
