package wr.leetcode.algo.sudoku_solver;

public class Solution {
    public void solveSudoku(char[][] board) {
        if( null == board || board.length != 9 || 9 != board[0].length ) {
            throw new IllegalStateException("Invalid input sudoku board!");
        }
        checkSudoku(board);

    }

    public boolean checkSudoku(char[][] board) {
        for (int i = 0; i < 9 ; ++i) {
            for (int j = 0; j < 9 ; ++j) {
                if('.' == board[i][j]) {
                    boolean [] taken = new boolean [9];
                    for (int k = 0; k < 9; ++k) {
                        if(board[i][k] != '.') {
                            taken[ board[i][k] - '1' ] = true;
                        }
                        if(board[k][j] != '.') {
                            taken[ board[k][j] - '1' ] = true;
                        }
                        char val = board[i/3*3 + k/3] [j/3*3 + k%3];
                        if(val != '.') {
                            taken[val - '1' ] = true;
                        }
                    }
                    for (int val = 1; val <=9; ++val) {
                        if(!taken[val-1]) {
                            board[i][j] = (char)(val + '0');
                            if(checkSudoku(board)) {
                                return true;
                            }
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

}