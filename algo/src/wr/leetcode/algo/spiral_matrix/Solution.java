package wr.leetcode.algo.spiral_matrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        if( null != matrix && matrix.length > 0 && matrix[0].length > 0) {
            //BUG: fix by minus 1
            int m = matrix.length-1;
            int n = matrix[0].length-1;

            int i;
            //BUG: should be n-1 instead of n!!!
            for ( i = 0; (i < n-i) && (i < m -i); ++i ) {
                for (int x = 0; i+x < n-i; ++x ) {
                    ret.add(matrix[i][i+x]);
                }
                for (int x = 0; i+x < m-i; ++x ) {
                    ret.add(matrix[i+x][n-i]);
                }
                for (int x = 0; n-i-x > i; ++x ) {
                    ret.add(matrix[m-i][n-i-x]);
                }
                for (int x = 0; m-i-x > i; ++x ) {
                    ret.add(matrix[m-i-x][i]);
                }
            }

            if(i == n-i) {
                for (int x = i; x <= m-i; ++x) {
                    ret.add(matrix[x][i]);
                }
            } else if(i == m-i) {
                for (int x = i; x <= n-i; ++x) {
                    ret.add(matrix[i][x]);
                }
            }
        }
        return ret;
    }
}
