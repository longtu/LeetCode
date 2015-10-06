package wr.leetcode.algo.maximal_square;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        int ret = 0;
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        return findMaxSquare(matrix);

    }

    public int findMaxSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int [][] colSums = new int[rows][cols];
        int [][] rowSums = new int[rows][cols];
        Set<Pair> origins = new HashSet<>();


        //col-level
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                colSums[i][j] =  ((i > 0)?(colSums[i-1][j]):(0))
                        + matrix[i][j] - '0';
                if( '1' == matrix[i][j]) {
                    origins.add(new Pair(i,j));
                }
            }
        }

        //row-level
        for (int j = 0; j < cols; ++j)
            for (int i = 0; i < rows; ++i) {
             {
                rowSums[i][j] =  ((j > 0)?(rowSums[i][j-1]):(0))
                        + matrix[i][j] - '0';
            }
        }

        int len = 0;
        if(!origins.isEmpty()) {
            for (len = 1; len <= Math.min(rows,cols); len++) {
                Set<Pair> nextOrigins = new HashSet<>();
                for (Pair pair : origins){
                    int row = pair.row;
                    int col = pair.col;
                    //ERROR:
                    if(col + len >= cols || row + len >= rows) {
                        continue;
                    }
                    int colBase = (row > 0)?(colSums[row-1][col+len]):(0);
                    int rowBase = (col > 0)?(rowSums[row + len][col-1]):(0);

                    if(colSums[row+len][col+len] - colBase == len +1
                            && rowSums[row+len][col+len] - rowBase == len +1) {
                        nextOrigins.add(pair);
                    }
                }
                if(nextOrigins.isEmpty()) {
                    break;
                }
                origins = nextOrigins;
            }
        }
        return len*len;
    }

    class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString(){
            return String.format("%d:%d", row, col);
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        Solution sol = new Solution();
        System.out.println(sol.maximalSquare(matrix));
    }
}
