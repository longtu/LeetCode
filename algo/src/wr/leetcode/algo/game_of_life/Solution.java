package wr.leetcode.algo.game_of_life;

public class Solution {
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
    }
}
