package wr.leetcode.algo.range_sum_query_2d_mutable;


public class NumMatrix {

    final int m;
    final int n;
    final int[][] matrix;
    final int[][] trees;


    public NumMatrix(int[][] matrix) {

        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            matrix = new int[1][0];
        }

        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        trees = new int[m][n+1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j <n; ++j) {
                updateTree(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        updateTree(row, col, diff);
        matrix[row][col] = val;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <=row2; ++r) {
            sum += sumRegionTree(r, col1, col2);
        }
        return sum;
    }

    private void updateTree(int row, int col, int val) {
        int[] tree = trees[row];
        int id = col + 1;

        while(id <= n) {
            tree[id] += val;
            id += (id & -id);
        }
    }

    private int sumRegionTree(int row, int left, int right) {
        int [] tree = trees[row];
        return sumRegionTree(tree, right) - sumRegionTree(tree, left-1);
    }

    private int sumRegionTree(int [] tree, int index) {
        int sum = 0;
        int id = index + 1;
        while(id > 0) {
            sum += tree[id];
            id -= (id & -id);
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix sol = new NumMatrix(matrix);

        System.out.println(sol.sumRegion(2, 1, 4, 3));
        sol.update(3,2,2);
        System.out.println(sol.sumRegion(2, 1, 4, 3));


        int[][] m = {};

        NumMatrix sol2 = new NumMatrix(m);
    }
}
