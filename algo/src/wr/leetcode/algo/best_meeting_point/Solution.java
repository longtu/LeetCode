package wr.leetcode.algo.best_meeting_point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int minTotalDistance(int[][] board) {
        int dist = 0;
        if( null != board && board.length > 0 && board[0].length > 0) {
            Integer[][] grid = coord(board);
            int n = grid.length;
            //GOOD: check for not empty!!!
            if( n > 0 ) {
                int[] x = new int[n];
                int[] y = new int[n];
                for (int i = 0; i < n; ++i) {
                    x[i] = grid[i][0];
                    y[i] = grid[i][1];
                }
                Arrays.sort(x);
                Arrays.sort(y);
                int mX = x[n / 2];
                int mY = y[n / 2];
                for (int i = 0; i < n; ++i) {
                    dist += Math.abs(mX - grid[i][0]);
                    dist += Math.abs(mY - grid[i][1]);
                }
            }
        }
        return dist;
    }


    Integer[][] coord (int[][] board) {
        List<Integer[]> points = new LinkedList<>();
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j) {
                if(1 == board[i][j]) {
                    points.add(new Integer[] {i, j});
                }
            }
        int n = points.size();
        Integer[][] ret = new Integer[n][2];
        points.toArray(ret);

        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        int[][] a = {
                {1}
        };
        int[][] b = {
                {0},
        };
        System.out.println(sol.minTotalDistance(grid));
        System.out.println(sol.minTotalDistance(a));
        System.out.println(sol.minTotalDistance(b));
        System.out.println(sol.minTotalDistance(grid));
    }
}
