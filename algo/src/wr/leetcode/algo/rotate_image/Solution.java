package wr.leetcode.algo.rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        if( null != matrix && matrix.length > 0 ) {
            int n = matrix.length;
            for (int i = 0; i < n-1-i; ++i) {
                for (int l = 0; i + l < n-1-i; ++l ) {
                    int first = matrix[i][i+l];
                    matrix[i][i+l] = matrix[n-1-i-l][i];
                    matrix[n-1-i-l][i] = matrix[n-1-i][n-1-i-l];
                    matrix[n-1-i][n-1-i-l] = matrix[i+l][n-1-i];
                    matrix[i+l][n-1-i] = first;
                }
            }
        }
    }
}
