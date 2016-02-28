package wr.leetcode.algo.Linkedin;

import java.util.Arrays;

public class BoardFormmater {

    public int[][] format( int n, int column ) {
        int[][] ret = new int[0][0];
        if (n > 0) {
            int r = n/column;
            int k = n%column;
            int nR = (k>0)?(r+1):(r);
            ret = new int[nR][column];

            int i = 0;
            int j = 0;
            for (int v = 1; v <=n; ++v ) {
                ret[i][j] = v;
                i++;
                if (i == r+1) {
                    i = 0;
                    j ++;
                } else if (i == r) {
                    if (j >= k) {
                        i = 0;
                        j++;
                    }
                }
            }
        }
        return ret;
    }

    public void disPlay ( int n, int column ) {
        if (n > 0) {
            int r = n/column;
            int k = n%column;
            int nR = (k>0)?(r+1):(r);

            for (int i = 0; i < nR; ++i) {
                int v = i+1;
                int w = (i == r)?(k):(column);
                for (int j = 0; j <w; ++j) {
                    System.out.print(v + " ");
                    if (j < k) {
                        v+= nR;
                    } else {
                        v+=r;
                    }
                }
                System.out.println("");
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        BoardFormmater solution = new BoardFormmater();
        for (int [] test : new int[][]{
                {7,10},
                {7,9},
                {7,8},
                {7,7},
                {7,6},
                {7,5},
                {7,4},
                {7,3},
                {7,2},
                {7,1}
        } ) {
            //print(solution.format(test[0], test[1]));
            solution.disPlay(test[0], test[1]);
        }

        solution.disPlay(39, 6);
        solution.disPlay(39, 7);
    }

    public static void print(int[][] array) {
        for (int[] arr : array) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
