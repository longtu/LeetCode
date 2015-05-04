package wr.leetcode.algo.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length) {
            return;
        }
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < board.length; ++i){
            if('0' == board[i][0] ) {
                explore(i, 0, board);
            }
            if('0' == board[i][w-1] ) {
                explore(i, w-1, board);
            }
        }

        for (int j = 0; j < w; ++j){
            if('0' == board[0][j] ) {
                explore(0, j, board);
            }
            if('0' == board[h-1][j] ) {
                explore(h-1, j, board);
            }
        }

        for(int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == 'V') {
                    board[i][j] = '0';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void explore(int x, int y, char[][] grid){
        Queue<Pos> queue = new LinkedList();
        queue.offer(new Pos(x, y));
        grid[x][y] = 'V';
        while(!queue.isEmpty()) {
            Pos node = queue.poll();
            int i = node.x;
            int j = node.y;
            if(i > 0 && grid[i-1][j] == '0') {
                grid[i-1][j] = 'V';
                queue.offer(new Pos(i-1,j));
            }
            if(j > 0 && grid[i][j-1] == '0') {
                grid[i][j-1] = 'V';
                queue.offer(new Pos(i,j-1));
            }

            if(i < grid.length-1 && grid[i+1][j] == '0') {
                grid[i+1][j] = 'V';
                queue.offer(new Pos(i+1,j));
            }

            if(j < grid[0].length-1 && grid[i][j+1] == '0') {
                grid[i][j+1] = 'V';
                queue.offer(new Pos(i,j+1));
            }
        }
    }

    class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
