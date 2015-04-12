package wr.leetcode.algo.n_queens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> sols = new LinkedList();
        if(n <= 0) {
            return sols;
        }
        int[]y = new int[n];
        List<int[]> solutions = solveNQueens(y, n, 0);
        if(solutions.size() > 0) {
            sols = draw(solutions);
        }
        return sols;
    }

    public List<String[]> draw(List<int[]> sols) {
        List<String[]> rets = new LinkedList();
        for(int[] y : sols) {
            int len = y.length;
            String[] ret = new String[len];
            for (int i = 0; i < len; ++i) {
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < len; ++k) {
                    sb.append(".");
                }
                sb.setCharAt(y[i], 'Q');
                ret[i] = sb.toString();
            }
            rets.add(ret);
        }
        return rets;
    }

    public List<int[]> solveNQueens(int[] y, int n, int curr) {
        List<int[]> ret = new LinkedList();
        if(curr == n) {
            ret.add(Arrays.copyOf(y, y.length));
            return ret;
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
                ret.addAll(solveNQueens(y, n, curr +1));
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String[]> sols = sol.solveNQueens(4);
        for(String[] s : sols) {
            System.out.println(Arrays.toString(s));
        }
    }
}
