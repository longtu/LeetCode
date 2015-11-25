package wr.leetcode.algo.n_queens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> draw ( int[] yPos ) {
        List<String> ret = new LinkedList<>();
        int n = yPos.length;
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                char ch;
                if(j == yPos[i]) {
                    ch = 'Q';
                } else {
                    ch = '.';
                }
                sb.append(ch);
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ret = new LinkedList<>();
        if(n > 0) {
            int [] yPos = new int[n];
            ret = solveNQueens(yPos, 0);
        }
        return ret;
    }

    public List<List<String>> solveNQueens(int[] yPos, int row) {
        int n = yPos.length;
        List<List<String>> ret = new LinkedList<>();

        if(row == n) {
            ret.add(draw(yPos));
        } else {
            for (int y = 0; y < n; ++y) {
                boolean valid = true;
                for (int k = 0; k < row; ++k) {
                    if (y == yPos[k] || (Math.abs(y-yPos[k]) == Math.abs(k-row))) {
                        valid = false;
                        break;
                    }
                }
                if(!valid) {
                    continue;
                }
                yPos[row] = y;
                ret.addAll(solveNQueens(yPos, row + 1));
            }
        }
        return ret;
    }





    /*
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
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> sols = sol.solveNQueens(4);
        for(List<String> s : sols) {
            System.out.println(s);
        }
    }
}
