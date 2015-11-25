package wr.leetcode.algo.set_matrix_zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if( null == matrix || 0 == matrix.length || 0 == matrix[0].length ) {
            return;
        }
        boolean firstColZero = false;
        boolean firstRowZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; ++i ){
            firstRowZero = firstRowZero || (0 == matrix[0][i]);
        }

        for (int i = 0; i < rows; ++i ){
            firstColZero = firstColZero || ( 0 == matrix[i][0] );
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if(0 == matrix[i][j]) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if(0 == matrix[0][j] || 0 == matrix[i][0]) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColZero) {
            for (int i = 0; i < rows; ++i) {
                matrix[i][0] = 0;
            }
        }

        //BUG: firstRowZero
        if(firstRowZero) {
            for (int j = 0; j < cols; ++j) {
                matrix[0][j] = 0;
            }
        }

    }
}
