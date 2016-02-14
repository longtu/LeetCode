package wr.leetcode.algo.spiral_matrix_ii;

public class Solution {
    public int[][] generateMatrix0(int n) {
        n = Math.abs(n);
        int[][] matrix = new int[n][n];
        int val = 1;
        for (int i = 0; i <= n-1-i; ++i) {
            if(i == n - 1 - i) {
                matrix[i][i] = val;
            } else {
                for (int x = 0; i+x < n-1-i; ++x) {
                    matrix[i][i+x] = val++;
                }
                for (int x = 0; i+x < n-1-i; ++x) {
                    matrix[i+x][n-1-i] = val++;
                }
                for (int x = 0; i+x < n-1-i; ++x) {
                    matrix[n-1-i][n-1-i-x] = val++;
                }
                for (int x = 0; i+x < n-1-i; ++x) {
                    matrix[n-1-i-x][i] = val++;
                }
            }
        }
        return matrix;
    }

    public int[][] generateMatrix(int n) {
        int [][] ret = null;
        n = Math.abs(n);
        if (n >= 0) {
            ret = new int[n][n];
            int v = 1;
            for (int i = 0; i <= n-1-i; ++i) {
                if (i == n-1-i) {
                    ret[i][i] = v;
                    break;
                }
                for (int j = 0; i + j < n-1-i; ++ j) {
                    ret[i][i+j] = v++;
                }
                for (int j = 0; i + j < n-1-i; ++ j) {
                    ret[i+j][n-1-i] = v++;
                }
                for (int j = 0; i + j < n-1-i; ++ j) {
                    ret[n-1-i][n-1-i-j] = v++;
                }
                for (int j = 0; i + j < n-1-i; ++ j) {
                    ret[n-1-i-j][i] = v++;
                }
            }
        }
        return ret;
    }

}