package wr.leetcode.algo.game_of_life;

public class Solution {


    public void gameOfLife(int[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length ) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        int[] diffR = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] diffC = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j ) {
                int val = board[i][j]%10;

                int neighbour = 0;
                for (int k = 0; k < 8; ++k) {
                    int r = i + diffR[k];
                    int c = j + diffC[k];
                    if( r >=0 && r < m && c >= 0 && c < n ) {
                        int v = board[r][c];
                        if( 1 == v%10 ) {
                            neighbour += 1;
                        }
                    }
                }
                int nextVal;
                //BUG: Typo neighbour instead of n
                if(1 == val) {
                    if(neighbour < 2 || neighbour > 3) {
                        nextVal = 1;
                    } else {
                        nextVal = 11;
                    }
                } else{
                    if(neighbour == 3) {
                        nextVal = 10;
                    } else {
                        nextVal = 0;
                    }
                }
                board[i][j] = nextVal;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = board[i][j]/10;
            }
        }
    }



    /*
    public void gameOfLife(int[][] board) {

        if(null == board || 0 == board.length || board[0].length == 0) {
            return;
        }

        int nowMask =  0x00000001;
        int nextMask = 0x00010000;
        int x [] = {-1,0,1,-1,1,-1,0,1};
        int y [] = {-1,-1,-1,0,0,1,1,1};

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j) {
                //EDGE!!
                int liveNeighbours = 0;
                boolean live = (board[i][j] & nowMask) == 1;
                for (int k = 0; k < 8; ++k) {
                    //EDGE!!!
                    if(x[k] + i < 0 || x[k] + i >= board.length ||
                            y[k] + j <0 || y[k] >= board[0].length) {
                        continue;
                    }
                    int val = board[ x[k] + i ][ y[k] +j ];
                    liveNeighbours += (val & nowMask);
                }
                if( (!live && liveNeighbours ==3)||
                    (live && liveNeighbours >=2 && liveNeighbours <= 3) ) {
                        board[i][j] = (board[i][j] | nextMask);
                }
        }

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j) {
                if((board[i][j] & nextMask) == nextMask) {
                    board[i][j] = 1;
                } else {//FORGOT TO RESET!
                    board[i][j] = 0;
                }
            }
    }*/
}
