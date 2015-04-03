package wr.leetcode.algo.sudoku_solver;

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) {
            return;
        }
        isValidSudoku(board);
    }

    public boolean isValidSudoku(char [][] board) {
        for (int i = 0; i< 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if(board[i][j] == '.') {
                    boolean[] occupied = new boolean[10];
                    for(int k = 0; k < 9; ++k) {
                        if(board[i][k] != '.') {
                            int idx = board[i][k] - '0';
                            occupied[idx] = true;
                        }
                        if(board[k][i] != '.') {
                            int idx = board[k][i] - '0';
                            occupied[idx] = true;
                        }
                    }
                    for (int u = i/3; u < i/3+3; ++u)
                        for(int v = j/3; v < j/3+3; ++v){
                            if(board[u][v] != '.') {
                                int idx = board[u][v] - '0';
                                occupied[idx] = true;
                            }
                        }

                    for(int k = 1; k <= 9; ++k) {
                        if(!occupied[k]) {
                            board[i][j] = (char) (k + '0');
                            if(isValidSudoku(board))
                                return true;
                        }
                    }
                    return false;
                }
            }
        return true;
    }
}