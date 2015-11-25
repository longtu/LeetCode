package wr.leetcode.algo.range_sum_query_2d_immutable;

public class NumMatrix {
    final int m;
    final int n;
    final int[][] sum;

    public NumMatrix(int[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length ) {
            matrix = new int[0][0];
        }
        m = matrix.length;
        //BUG: in case m ==0 this will fail
        n = (0 == m)? (0):(matrix[0].length);
        sum = new int[m+1][n+1];

        for (int i = 0; i<=m; ++i) {
            for (int j = 0; j <=n; ++j ) {
                int val;
                if(0 == i || 0 ==j) {
                    val = 0;
                } else {
                    val = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1]
                        -sum[i-1][j-1];
                }

                sum[i][j] = val;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //BUG: check empty array
        if( 0 == m || 0 == n){
            return 0;
        }
        return sum[row2+1][col2+1] + sum[row1][col1] - sum[row1][col2+1]
                -sum[row2+1][col1];
    }


    public static void main(String[] args) {

        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        //int[][] matrix = new int[0][0];

        NumMatrix sol = new NumMatrix(matrix);

        System.out.println(sol.sumRegion(2,1,4,3));
        System.out.println(sol.sumRegion(1,1,2,2));
        System.out.println(sol.sumRegion(1,2,2,4));
    }
}
