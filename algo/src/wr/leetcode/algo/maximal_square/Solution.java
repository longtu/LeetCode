package wr.leetcode.algo.maximal_square;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

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

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (null != matrix && matrix.length > 0 && matrix[0].length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;

            int [][] squres = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    char ch = matrix[i][j];
                    int val = 0;
                    if (ch == '1' ) {
                        val = 1;
                        if (i > 0 && j > 0) {
                            val += Math.min(
                                    Math.min(squres[i-1][j], squres[i][j-1]),
                                    squres[i-1][j-1]
                            );
                        }
                        max = Math.max(max, val);
                    }
                    squres[i][j] = val;
                }
            }
        }
        return max*max;
    }



/*
    public int maximalSquare(char[][] matrix) {
        int ret = 0;
        if(null != matrix && matrix.length > 0 && matrix[0].length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;

            int l = 0;
            Queue<Pos> nextQ = new LinkedList<Pos>();
            for (int i = 0; i < m; ++i){
                for (int j = 0; j < n; ++j) {
                    if(matrix[i][j] == '1') {
                        nextQ.add(new Pos(i,j));
                    }
                }
            }

            int maxL = 0;
            while(!nextQ.isEmpty()) {
               // l+= 1; BUG: should not update here
                Queue<Pos> q = nextQ;
                nextQ = new LinkedList<>();
                l += 1;
                while(!q.isEmpty()) {
                    Pos p = q.remove();
                    int sx = p.x;
                    int sy = p.y;
                    boolean isSquare = true;
                    for (int i = 0; i <= l; ++i) { //BUG: starting with 0
                        int x = sx + i;
                        int y = sy + i;
                        if(x >= m || y >= n || sy +l >=n || sx +l >=m ||
                                matrix[x][sy+l] != '1' ||
                            matrix[sx+l][y] != '1') {
                            isSquare = false;
                            break;
                        }
                    }
                    if(isSquare) {
                        nextQ.add(new Pos(sx, sy));
                    }
                }
            }
            ret = l*l;
        }
        return ret;
    }

    public class Pos {
        int x;
        int y;
        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
*/





    /*public int maximalSquare(char[][] matrix) {

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
    }*/

}
