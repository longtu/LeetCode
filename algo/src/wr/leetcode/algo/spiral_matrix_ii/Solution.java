package wr.leetcode.algo.spiral_matrix_ii;

public class Solution {
    public int[][] generateMatrix(int n) {
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
}