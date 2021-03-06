package wr.leetcode.algo.valid_sudoku;

public class Solution {

    public boolean isValidSudoku(char[][] board) {

     boolean [][] h = new boolean[9][9];
     boolean [][] v = new boolean[9][9];
     boolean [][][] x = new boolean[3][3][9];

     if(null == board || board.length != 9 || board[0].length != 9) {
        throw new IllegalStateException("Invalid input sudoku board!");
    }

    boolean ret = true;
    for (int i = 0; i < 9 && ret; ++i) {
        for (int j = 0; j < 9 && ret; ++j) {
            if('.' == board[i][j]) {
                continue;
            }
            int val = (board[i][j] - '0');
            if( h[i][val-1] || v[j][val-1] || x[i/3][j/3][val-1]) {
                ret = false;
            } else {
                h[i][val-1] = true;
                v[j][val-1] = true;
                x[i/3][j/3][val-1] = true;
            }
        }
    }
    return ret;
}







/*
    public boolean isValidSudoku(char[][] board) {

    	if(null == board || board[0].length == 0) {
    		return true;
    	}

    	if(board.length != board[0].length) {
    		return false;
    	}

    	int n = board.length;
    	for (int i = 0; i < n; ++ i) {
    		boolean[] row = new boolean[n+1];
    		boolean[] col = new boolean[n+1];

    		for (int j = 0; j < n; ++ j) {
    			if(board[i][j] != '.') {
    				int val = board[i][j] - '0';
    				if(row[val]) {
    					return false;
    				} else {
    					row[val] = true;
    				}
    			}
    			if (board[j][i] != '.') {
    				int val = board[j][i] - '0';
    				if(col[val]) {
    					return false;
    				} else {
    					col[val] = true;
    				}
    			}
    		}
    	}

        //tons of bugs here:
    	for (int ib = 0; ib < 9; ib +=3)
    		for (int jb = 0; jb < 9; jb +=3) {
    			boolean [] sub = new boolean[10];
    			for (int i = 0; i< 3; ++i)
    				for (int j = 0; j<3; ++j) {
    					// this index access has bugs
                        if(board[ib+i][jb+j] != '.') {
    						int val = board[ib+i][jb+j] - '0';
    						if(sub[val]){
    							return false;
    						} else {
    							sub[val] = true;
    						}

    					}
    				}
    		}

    	return true;
    }

    public boolean isValidSudoku0(char[][] board) {

        boolean [][] rows = new boolean[board.length][board[0].length+1];
        boolean [][] cols = new boolean[board.length][board[0].length+1];
        boolean [][] subs = new boolean[board.length][board[0].length+1];

        for( int i = 0; i < board.length; ++i) {
            Arrays.fill(rows[i], false);
            Arrays.fill(cols[i], false);
            Arrays.fill(subs[i], false);
        }

        for( int i = 0; i < board.length; ++i)
            for( int j = 0; j < board[0].length; ++j) {
                if(board[i][j] != '.') {
                    int value = board[i][j] - '0';
                    if(     rows[i][value] == true ||
                            cols[j][value] == true ||
                            subs[i/3 * 3 + j/3 ] [value] == true ) {
                        return false;
                    }

                    rows[i][value] = true;
                    cols[j][value] = true;
                    subs[i/3 * 3 + j/3 ] [value] = true;
                }
            }
        return true;
    }*/


}