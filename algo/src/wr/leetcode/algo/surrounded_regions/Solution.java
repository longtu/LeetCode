package wr.leetcode.algo.surrounded_regions;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {{'0'}};

        sol.solve(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

    }

    public void solve(char[][] board) {

        if( null == board || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            explore(board, i, 0);
            explore(board, i, n-1);
        }
        for (int i = 0; i < n; ++i) {
            explore(board, 0, i);
            explore(board, m-1, i);
        }

        for (int i = 0; i < m;++i) {
            for (int j = 0; j < n; ++j) {
                int val = board[i][j];
                board[i][j] = (val == 'k')?('O'):('X');
            }
        }
    }

    public void explore(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        Queue<Pos> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        if ( 'O' == board[x][y] ) {
            queue.offer(new Pos(x, y));
            visited.add(index(x, y, n));
        }
        int [] dx = {-1, 0, 0, 1};
        int [] dy = {0, -1, 1, 0};
        while(!queue.isEmpty()) {
            Pos v = queue.poll();
            board[v.x][v.y] = 'k';
            for (int i = 0; i < 4; ++i) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                int index = index(nx, ny, n);
                if (nx >= 0 && nx < m && ny >=0 && ny < n &&
                        board[nx][ny] == 'O' && !visited.contains(index)) {
                    visited.add(index);
                    queue.offer(new Pos(nx,ny));
                }
            }
        }
    }

    public int index(int x, int y, int cols) {
        return x*cols +y;
    }

    class Pos {
        int x;
        int y;
        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /*

    public void solve(char[][] board) {
        if( null != board && 0 != board.length && board[0].length != 0 ) {
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; ++i){
                if('O' == board[i][0] ) {
                    explore(i, 0, board);
                }
                if('O' == board[i][n-1] ) {
                    explore(i, n-1, board);
                }
            }

            for (int j = 0; j < n; ++j){
                if('O' == board[0][j] ) {
                    explore(0, j, board);
                }
                if('O' == board[m-1][j] ) {
                    explore(m-1, j, board);
                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j ) {
                    char ch = board[i][j];
                    if( '1' == ch ) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public void explore( int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int xdiff [] = {0, -1, 1, 0};
        int ydiff [] = {-1, 0, 0, 1};
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x,y));
        while(!q.isEmpty()) {

            Pos node = q.remove();
            //GOOD: avoid duplicate visit among different explore sessions


            for (int i = 0; i < 4; ++i) {
                int dx = xdiff[i] + node.x;
                int dy = ydiff[i] + node.y;

                if(dx >= 0 && dy >=0 && dx < m && dy < n && 'O' == board[dx][dy]) {
                    q.add(new Pos(dx,dy));
                    board[node.x][node.y] = '1';
                }
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

    /*
    public void solve(char[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length) {
            return;
        }
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < board.length; ++i){
            if('O' == board[i][0] ) {
                explore(i, 0, board);
            }
            if('O' == board[i][w-1] ) {
                explore(i, w-1, board);
            }
        }

        for (int j = 0; j < w; ++j){
            if('O' == board[0][j] ) {
                explore(0, j, board);
            }
            if('O' == board[h-1][j] ) {
                explore(h-1, j, board);
            }
        }

        for(int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == 'V') {
                    board[i][j] = 'O';
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
            if(i > 0 && grid[i-1][j] == 'O') {
                grid[i-1][j] = 'V';
                queue.offer(new Pos(i-1,j));
            }
            if(j > 0 && grid[i][j-1] == 'O') {
                grid[i][j-1] = 'V';
                queue.offer(new Pos(i,j-1));
            }

            if(i < grid.length-1 && grid[i+1][j] == 'O') {
                grid[i+1][j] = 'V';
                queue.offer(new Pos(i+1,j));
            }

            if(j < grid[0].length-1 && grid[i][j+1] == 'O') {
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
    */
}
