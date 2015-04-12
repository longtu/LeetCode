package wr.leetcode.algo.n_queens_ii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int totalNQueens(int n) {
        int ret= 0;
        if(n <= 0) {
            return ret;
        }
        int[]y = new int[n];
        return solveNQueens(y, n, 0);
    }

    public int solveNQueens(int[] y, int n, int curr) {
        int ret = 0;
        if(curr == n) {
            return 1;
        }
        for (int i = 0; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < curr; ++j) {
                if(y[j] == i ||
                        (Math.abs(y[j]-i) == curr - j)) {
                    valid = false;
                }
            }
            if(valid){
                y[curr] = i;
                ret += solveNQueens(y, n, curr +1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalNQueens(4));
    }

}
